import { PencilIcon, PlusIcon, TrashIcon } from '@heroicons/react/24/outline';
import React from 'react';
import { cn } from '@/lib/utils';
import { Button } from '@/components/ui/button';
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle
} from '@/components/ui/card';
import { type Workout } from '@/app/workouts/types'; // import the Workout type

interface WorkoutCardProps extends CardProps {
  workout: Workout;
}

type ColorMap = Record<number, string>;

type CardProps = React.ComponentProps<typeof Card>;

export default function WorkoutCard({
  workout,
  className,
  ...props
}: WorkoutCardProps) {
  const colorMap: ColorMap = {
    7: 'bg-green-500',
    8: 'bg-yellow-500',
    9: 'bg-orange-500',
    10: 'bg-red-500'
  };

  return (
    <Card className={cn('w-[380px]', className)} {...props}>
      <CardHeader>
        <CardTitle>
          {workout.name.charAt(0).toUpperCase() + workout.name.slice(1)}
        </CardTitle>
        <CardDescription>
          <span>{new Date(workout.dateTime).toLocaleTimeString()}</span>
        </CardDescription>
      </CardHeader>
      <CardContent className="grid gap-4">
        <div>
          {workout.sets
            .sort(
              (a, b) =>
                new Date(b.dateTime).getTime() - new Date(a.dateTime).getTime()
            )
            .map(set => {
              const colorClass =
                set.rpe <= 6
                  ? 'bg-blue-500'
                  : colorMap[set.rpe] || 'bg-deep-red-500';
              return (
                <div
                  key={set.id}
                  className="mb-4 grid grid-cols-2 items-start pb-4 last:mb-0 last:pb-0"
                >
                  <div className="flex">
                    <span
                      className={`flex h-2 w-2 translate-y-1 rounded-full ${colorClass}`}
                    />
                    <div className="ml-4 space-y-1">
                      <p className="text-sm font-medium leading-none">
                        {set.weight} lbs x {set.reps}
                      </p>
                      <p className="text-muted-foreground text-sm">
                        RPE {set.rpe}
                      </p>
                    </div>
                  </div>
                  <div className="flex justify-end space-x-3">
                    <TrashIcon className="h-5 w-5 cursor-pointer transition duration-500 hover:text-red-500" />
                    <PencilIcon className="ml-4 h-5 cursor-pointer" />
                  </div>
                </div>
              );
            })}
        </div>
      </CardContent>
      <CardFooter>
        <Button className="w-full">
          <PlusIcon className="mr-2 h-4 w-4" /> Add set
        </Button>
      </CardFooter>
    </Card>
  );
}
