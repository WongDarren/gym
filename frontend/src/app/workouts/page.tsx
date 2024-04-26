'use client';

import axios from 'axios';
import { useEffect, useState } from 'react';
import WorkoutTable from '@/app/components/workout-table';
import { type Workout } from './types';

interface ApiResponse {
  workouts: Workout[];
}

async function getWorkouts(): Promise<Workout[]> {
  try {
    const response = await axios.get<ApiResponse>(
      'http://localhost:8080/api/workouts'
    );
    return response.data.workouts;
  } catch (error) {
    console.error('Error:', error);
    return []; // return an empty array in case of an error
  }
}

// TODO: Edit a workout
// TODO: Add a set to a workout
// TODO: Edit a set
// TODO: Confirm delete prompt
// TODO: Allow cascading delete of a workout and its sets when you delete a workout (NEEDS CONFIRMATION)

export default function Workouts() {
  const [workouts, setWorkouts] = useState<Workout[]>([]);
  const [workoutName, setWorkoutName] = useState('');

  async function createWorkout(name: string): Promise<Workout> {
    try {
      const response = await axios.post<Workout>(
        'http://localhost:8080/api/workouts',
        { name }
      );
      return response.data;
    } catch (error) {
      console.error('Error:', error);
      throw error;
    }
  }

  async function deleteWorkout(workoutId: number): Promise<void> {
    try {
      await axios.delete(
        `http://localhost:8080/api/workouts/${workoutId.toString()}`
      );
      // Remove the workout from the workouts state
      setWorkouts(prevWorkouts =>
        prevWorkouts.filter(workout => workout.id !== workoutId)
      );
    } catch (error) {
      console.error('Error:', error);
    }
  }

  async function deleteSet(setId: number): Promise<void> {
    try {
      await axios.delete(`http://localhost:8080/api/sets/${setId.toString()}`);
      // Remove the set from the workouts state
      setWorkouts(prevWorkouts =>
        prevWorkouts.map(workout => ({
          ...workout,
          sets: workout.sets.filter(set => set.id !== setId)
        }))
      );
    } catch (error) {
      console.error('Error:', error);
    }
  }

  useEffect(() => {
    void getWorkouts().then(fetchedWorkouts => {
      // Sort the workouts in descending order
      fetchedWorkouts.sort(
        (a, b) =>
          new Date(b.dateTime).getTime() - new Date(a.dateTime).getTime()
      );
      setWorkouts(fetchedWorkouts);
    });
  }, []);

  return (
    <>
      <input
        type="text"
        value={workoutName}
        style={{ border: '1px solid #000' }}
        onChange={e => {
          setWorkoutName(e.target.value);
        }}
      />
      <WorkoutTable
        workouts={workouts}
        buttonText="Add Workout"
        buttonOnClick={async () => {
          if (workoutName) {
            const newWorkout = await createWorkout(workoutName);
            setWorkouts(prevWorkouts => [newWorkout, ...prevWorkouts]);
            setWorkoutName(''); // reset the input field
          }
        }}
        onDeleteSet={(setId: number) => {
          deleteSet(setId).catch((error: unknown) => {
            console.error('Error:', error);
          });
        }}
        onDeleteWorkout={(workoutId: number) => {
          deleteWorkout(workoutId).catch((error: unknown) => {
            console.error('Error:', error);
          });
        }}
      />
    </>
  );
}
