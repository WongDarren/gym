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
// TODO: Delete a workout
// TODO: Add a set to a workout
// TODO: Edit a set
// TODO: Delete a set

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
      />
    </>
  );
}
