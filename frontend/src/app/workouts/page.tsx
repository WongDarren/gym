'use client';

import { useEffect, useState } from 'react';

interface Set {
  id: number;
  dateTime: string;
  setNumber: number;
  weight: number;
  reps: number;
  rpe: number;
  warmup: boolean;
}

interface Workout {
  id: number;
  dateTime: string;
  name: string;
  sets: Set[];
}

export default function Workouts() {
  const [workouts, setWorkouts] = useState<Workout[]>([]);
  useEffect(() => {
    fetch('http://localhost:8080/api/workouts')
      .then(res => res.json())
      .then((data: { workouts: Workout[] }) => {
        console.log('Data from server:', data.workouts);
        setWorkouts(data.workouts);
      })
      .catch((error: unknown) => {
        console.error('Error:', error);
      });
  }, []);

  return (
    <div className="text-white">
      {workouts.map(workout => (
        <div key={workout.id} className="mb-4">
          <h2 className="text-2xl font-bold">{workout.name}</h2>
          <p>Date: {workout.dateTime}</p>
          <p>Sets:</p>
          {workout.sets.map(set => (
            <div key={set.id} className="ml-4">
              <p>Set Number: {set.setNumber}</p>
              <p>Weight: {set.weight}</p>
              <p>Reps: {set.reps}</p>
              <p>RPE: {set.rpe}</p>
              <p>Warmup: {set.warmup ? 'Yes' : 'No'}</p>
              <br />
            </div>
          ))}
        </div>
      ))}
    </div>
  );
}
