'use client';

import { zodResolver } from '@hookform/resolvers/zod';
import { format, startOfDay } from 'date-fns';
import { CalendarIcon } from 'lucide-react';
import { useForm } from 'react-hook-form';
import { z, type ZodType } from 'zod';
import { cn } from '@/lib/utils';
import { Button } from '@/components/ui/button';
import { Calendar } from '@/components/ui/calendar';
import {
  Popover,
  PopoverContent,
  PopoverTrigger
} from '@/components/ui/popover';
import { Form, FormControl, FormField, FormItem } from '@/components/ui/form';
import { useToast } from '@/components/ui/use-toast';

interface DatePickerFormProps {
  onDateChange: (date: Date) => void;
}

const FormSchema = z.object({
  workoutDate: z.date({})
});

type FormData = z.infer<typeof FormSchema>;

export default function DatePickerForm({ onDateChange }: DatePickerFormProps) {
  const form = useForm<FormData>({
    resolver: zodResolver<ZodType<FormData>>(FormSchema),
    defaultValues: {
      workoutDate: startOfDay(new Date()) // Set the default date in the form's state
    }
  });

  const { toast } = useToast();

  function onSubmit() {
    try {
      const data = form.getValues();
      onDateChange(data.workoutDate);
      toast({
        description: 'Submitted!',
        variant: 'success'
      });
    } catch (error) {
      console.error(error);
    }
  }

  return (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-8">
        <div className="flex flex-row items-center justify-center space-x-4">
          <FormField
            control={form.control}
            name="workoutDate"
            render={({ field }) => (
              <FormItem className="flex flex-col">
                <Popover>
                  <PopoverTrigger asChild>
                    <FormControl>
                      <Button
                        variant="outline"
                        className={cn(
                          'w-[240px] pl-3 text-left font-normal',
                          !field.value && 'text-muted-foreground'
                        )}
                      >
                        {
                          field.value
                            ? format(field.value, 'PPP')
                            : format(startOfDay(new Date()), 'PPP') // Default to today's date
                        }
                        <CalendarIcon className="ml-auto h-4 w-4 opacity-50" />
                      </Button>
                    </FormControl>
                  </PopoverTrigger>
                  <PopoverContent className="w-auto p-0" align="start">
                    <Calendar
                      mode="single"
                      selected={field.value}
                      onSelect={field.onChange}
                      disabled={date =>
                        date > new Date() || date < new Date('1900-01-01')
                      }
                      initialFocus
                    />
                  </PopoverContent>
                </Popover>
              </FormItem>
            )}
          />
          <Button type="submit">Submit</Button>
        </div>
      </form>
    </Form>
  );
}
