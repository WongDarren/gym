'use client';

import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { isSameDay } from 'date-fns';
import WorkoutCard from '@/components/workout-card';
import type { Workout } from '@/app/workouts/types';

interface ApiResponse {
  workouts: Workout[];
}

interface WorkoutGridProps {
  selectedDate: Date;
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

export default function WorkoutGrid({ selectedDate }: WorkoutGridProps) {
  const [workouts, setWorkouts] = useState<Workout[]>([]);

  useEffect(() => {
    void getWorkouts().then(fetchedWorkouts => {
      // Filter the workouts based on the selected date
      const filteredWorkouts = fetchedWorkouts.filter(workout =>
        isSameDay(new Date(workout.dateTime), selectedDate)
      );

      // Sort the workouts in descending order
      filteredWorkouts.sort(
        (a, b) =>
          new Date(b.dateTime).getTime() - new Date(a.dateTime).getTime()
      );

      setWorkouts(filteredWorkouts);
    });
  }, [selectedDate]); // Add selectedDate as a dependency to the useEffect hook

  return (
    <div className="my-8">
      <ul className="flex flex-col items-center gap-6">
        {workouts.map(workout => (
          <li key={workout.id}>
            <WorkoutCard workout={workout} />
          </li>
        ))}
      </ul>
    </div>
  );
}
