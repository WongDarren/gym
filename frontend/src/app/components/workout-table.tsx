import { PencilSquareIcon, TrashIcon } from '@heroicons/react/24/outline';
import React from 'react';
import Button from '@/app/components/ui/button';
import { type Set, type Workout } from '@/app/workouts/types';

interface TableProps {
  workouts: Workout[];
}

interface ButtonProps {
  buttonText: string;
  buttonOnClick?: () => Promise<void>;
  onDeleteSet: (setId: number) => void;
  onDeleteWorkout: (workoutId: number) => void;
}

function WorkoutRow({
  workout,
  onDeleteWorkout
}: {
  workout: Workout;
  onDeleteWorkout: (workoutId: number) => void;
}) {
  return (
    <tr>
      <td
        colSpan={6}
        className=" whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-gray-700 sm:pl-0"
      >
        <span>{`${workout.name} - ${new Date(workout.dateTime).toLocaleDateString()} - ${new Date(workout.dateTime).toLocaleTimeString()}`}</span>
      </td>
      <td>
        <TrashIcon
          className="h-5 w-5 cursor-pointer text-gray-500 transition duration-500 hover:text-red-500"
          onClick={() => {
            onDeleteWorkout(workout.id);
          }}
        />
      </td>
    </tr>
  );
}

function SetRow({
  set,
  onDeleteSet
}: {
  set: Set;
  onDeleteSet: (setId: number) => void;
}) {
  return (
    <tr>
      <td className="hidden whitespace-nowrap px-3 py-4 text-sm text-gray-500 sm:table-cell">
        {set.setNumber}
      </td>
      <td className="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
        {set.weight}
      </td>
      <td className="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
        {set.reps}
      </td>
      <td className="hidden whitespace-nowrap px-3 py-4 text-sm text-gray-500 sm:table-cell">
        {set.rpe}
      </td>
      <td className="hidden whitespace-nowrap px-3 py-4 text-sm text-gray-500 sm:table-cell">
        {set.warmup ? 'Warmup' : 'Workout'}
      </td>
      <td>
        <TrashIcon
          className="h-5 w-5 cursor-pointer text-gray-500 transition duration-500 hover:text-red-500"
          onClick={() => {
            onDeleteSet(set.id);
          }}
        />
      </td>
      <td>
        <PencilSquareIcon
          className="h-5 w-5 text-gray-500"
          aria-hidden="true"
        />
      </td>
    </tr>
  );
}

function WorkoutHeader() {
  return (
    <tr>
      <th
        colSpan={6}
        scope="col"
        className="py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-0"
      >
        Workouts
      </th>
      <th />
    </tr>
  );
}

function SetHeader() {
  return (
    <tr>
      <th
        scope="col"
        className="hidden px-3 py-3.5 text-left text-sm font-semibold text-gray-900 sm:table-cell"
      >
        Set
      </th>
      <th
        scope="col"
        className="px-3 py-3.5 text-left text-sm font-semibold text-gray-900"
      >
        Weight
      </th>
      <th
        scope="col"
        className="px-3 py-3.5 text-left text-sm font-semibold text-gray-900"
      >
        Reps
      </th>
      <th
        scope="col"
        className="hidden px-3 py-3.5 text-left text-sm font-semibold text-gray-900 sm:table-cell"
      >
        RPE
      </th>
      <th
        scope="col"
        className="hidden px-3 py-3.5 text-left text-sm font-semibold text-gray-900 sm:table-cell"
      >
        Warmup
      </th>
      <th scope="col" />
      <th scope="col" />
    </tr>
  );
}

export default function WorkoutTable({
  workouts,
  buttonText,
  buttonOnClick,
  onDeleteSet,
  onDeleteWorkout
}: TableProps & ButtonProps) {
  return (
    <div className="px-4 sm:px-6 lg:px-8">
      <div className="sm:flex sm:items-center">
        <div className="mt-4 sm:ml-16 sm:mt-0 sm:flex-none">
          <Button text={buttonText} onClick={buttonOnClick} />
        </div>
      </div>
      <div className="-mx-4 mt-8 sm:-mx-0">
        <table className="min-w-full table-auto divide-y divide-gray-300">
          <thead>
            <WorkoutHeader />
          </thead>
          <tbody className="divide-y divide-gray-200 bg-white">
            {workouts.map(workout => (
              <React.Fragment key={workout.id}>
                <WorkoutRow
                  workout={workout}
                  onDeleteWorkout={onDeleteWorkout}
                />
                {workout.sets && workout.sets.length > 0 ? (
                  <>
                    <SetHeader />
                    {workout.sets.map(set => (
                      <SetRow
                        key={set.id}
                        set={set}
                        onDeleteSet={onDeleteSet}
                      />
                    ))}
                  </>
                ) : null}
              </React.Fragment>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
