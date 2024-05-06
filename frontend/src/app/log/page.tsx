'use client';

import React, { useState } from 'react';
import { PlusIcon } from '@heroicons/react/24/outline';
import DatePickerForm from '@/components/date-picker-form';
import WorkoutGrid from '@/components/workout-grid';
import { Button } from '@/components/ui/button';

export default function LogPage() {
  const [selectedDate, setSelectedDate] = useState<Date>(new Date());

  return (
    <div className="my-8">
      <div className="flex items-center justify-center space-x-4">
        <DatePickerForm onDateChange={setSelectedDate} />
        <Button>
          <PlusIcon className="mr-2 h-4 w-4" /> Add workout
        </Button>
      </div>
      <WorkoutGrid selectedDate={selectedDate} />
    </div>
  );
}
