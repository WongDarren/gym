'use client';

import React, { useState } from 'react';
import { PlusIcon } from '@heroicons/react/24/outline';
import DatePickerForm from '@/components/date-picker-form';
import WorkoutGrid from '@/components/workout-grid';
import { Button } from '@/components/ui/button';
import { SetForm } from '@/components/set-form';
import BottomGradient from '@/components/ui/bottom-gradient';

export default function LogPage() {
  const [selectedDate, setSelectedDate] = useState<Date>(new Date());

  return (
    <div className="my-8">
      <div className="flex items-center justify-center space-x-4">
        <DatePickerForm onDateChange={setSelectedDate} />
        <Button
          className="group/btn relative flex h-10 rounded-md bg-gradient-to-br from-black to-neutral-600 font-medium text-white shadow-[0px_1px_0px_0px_#ffffff40_inset,0px_-1px_0px_0px_#ffffff40_inset] dark:bg-zinc-800 dark:from-zinc-900 dark:to-zinc-900 dark:shadow-[0px_1px_0px_0px_var(--zinc-800)_inset,0px_-1px_0px_0px_var(--zinc-800)_inset]"
          type="submit"
        >
          <PlusIcon className="mr-2 h-4 w-4" /> Add workout
          <BottomGradient />
        </Button>
      </div>
      <WorkoutGrid selectedDate={selectedDate} />
      <SetForm />
    </div>
  );
}
