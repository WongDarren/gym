'use client';

import axios from 'axios';
import { useEffect, useState } from 'react';
import Button from '@/app/components/ui/button';

interface Set {
  id: number;
  dateTime: string;
  workoutId: number;
  setNumber: number;
  weight: number;
  reps: number;
  rpe: number;
  warmup: boolean;
}

interface Workout {
  id: number;
  name: string;
  dateTime: string;
  sets: Set[];
}

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

export default function Workouts() {
  const [workouts, setWorkouts] = useState<Workout[]>([]);

  async function createWorkout(name: string): Promise<void> {
    try {
      await axios.post('http://localhost:8080/api/workouts', { name });
      // After successfully creating a workout, fetch the updated list of workouts
      const updatedWorkouts = await getWorkouts();
      setWorkouts(updatedWorkouts);
    } catch (error) {
      console.error('Error:', error);
    }
  }

  useEffect(() => {
    void getWorkouts().then(setWorkouts);
  }, []);

  return (
    <>
      <div>Workouts</div>
      <Button text="Add Workout" onClick={() => createWorkout('squat')} />{' '}
      {workouts.map(workout => (
        <div key={workout.id} className="mb-4">
          <h2 className="text-2xl font-bold">{workout.name}</h2>
          <p className="text-gray-500">
            {new Date(workout.dateTime).toLocaleString()}
          </p>
          {workout.sets.map(set => (
            <div
              key={set.id}
              className="mt-2 border-t border-gray-200 bg-gray-100 p-3"
            >
              <p className="text-sm">Set Number: {set.setNumber}</p>
              <p className="text-sm">Weight: {set.weight}</p>
              <p className="text-sm">Reps: {set.reps}</p>
              <p className="text-sm">RPE: {set.rpe}</p>
              <p className="text-sm">Warmup: {set.warmup ? 'Yes' : 'No'}</p>
              <p className="text-sm">
                Set Time: {new Date(set.dateTime).toLocaleString()}
              </p>
            </div>
          ))}
        </div>
      ))}
    </>
  );
}
