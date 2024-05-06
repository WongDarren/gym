'use client';

import React, { useState } from 'react';
import { Label } from '@/components/ui/label';
import { Input } from '@/components/ui/input';
import { cn } from '@/lib/utils';
import { Button } from '@/components/ui/button';
import BottomGradient from '@/components/ui/bottom-gradient';

export function SetForm() {
  const [setNumber, setSetNumber] = useState(0);
  const [weight, setWeight] = useState(0);
  const [reps, setReps] = useState(0);
  const [rpe, setRpe] = useState(0);

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    console.log('Form submitted with set data:', {
      setNumber,
      weight,
      reps,
      rpe
    });
  };

  return (
    <div className="shadow-input mx-auto w-full max-w-md rounded-none bg-white p-4 dark:bg-black md:rounded-2xl md:p-8">
      <form className="my-2" onSubmit={handleSubmit}>
        {/* ... other form fields ... */}
        <LabelInputContainer className="mb-4">
          <Label htmlFor="setNumber">Set Number</Label>
          <Input
            id="setNumber"
            type="number"
            value={setNumber}
            onChange={e => {
              setSetNumber(Number(e.target.value));
            }}
          />
        </LabelInputContainer>
        <LabelInputContainer className="mb-4">
          <Label htmlFor="weight">Weight</Label>
          <Input
            id="weight"
            type="number"
            value={weight}
            onChange={e => {
              setWeight(Number(e.target.value));
            }}
          />
        </LabelInputContainer>
        <LabelInputContainer className="mb-4">
          <Label htmlFor="reps">Reps</Label>
          <Input
            id="reps"
            type="number"
            value={reps}
            onChange={e => {
              setReps(Number(e.target.value));
            }}
          />
        </LabelInputContainer>
        <LabelInputContainer className="mb-4">
          <Label htmlFor="rpe">RPE</Label>
          <Input
            id="rpe"
            type="number"
            value={rpe}
            onChange={e => {
              setRpe(Number(e.target.value));
            }}
          />
        </LabelInputContainer>
        <Button
          className="group/btn relative block h-10 w-full rounded-md bg-gradient-to-br from-black to-neutral-600 font-medium text-white shadow-[0px_1px_0px_0px_#ffffff40_inset,0px_-1px_0px_0px_#ffffff40_inset] dark:bg-zinc-800 dark:from-zinc-900 dark:to-zinc-900 dark:shadow-[0px_1px_0px_0px_var(--zinc-800)_inset,0px_-1px_0px_0px_var(--zinc-800)_inset]"
          type="submit"
        >
          Submit &rarr;
          <BottomGradient />
        </Button>
      </form>
    </div>
  );
}

function LabelInputContainer({
  children,
  className
}: {
  children: React.ReactNode;
  className?: string;
}) {
  return (
    <div className={cn('flex w-full flex-col space-y-2', className)}>
      {children}
    </div>
  );
}
