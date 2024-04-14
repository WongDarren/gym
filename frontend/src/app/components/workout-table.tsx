import Button from '@/app/components/ui/button';
import { type Workout } from '@/app/workouts/types';

interface TableProps {
  workouts: Workout[];
  title: string;
  description: string;
}

interface ButtonProps {
  buttonText: string;
  buttonOnClick?: () => Promise<void>;
}

export default function WorkoutTable({
  workouts,
  title,
  description,
  buttonText,
  buttonOnClick
}: TableProps & ButtonProps) {
  return (
    <div className="px-4 sm:px-6 lg:px-8">
      <div className="sm:flex sm:items-center">
        <div className="sm:flex-auto">
          <h1 className="text-base font-semibold leading-6 text-gray-900">
            {title}
          </h1>
          <p className="mt-2 text-sm text-gray-700">{description}</p>
        </div>
        <div className="mt-4 sm:ml-16 sm:mt-0 sm:flex-none">
          <Button text={buttonText} onClick={buttonOnClick} />
        </div>
      </div>
      <div className="-mx-4 mt-8 sm:-mx-0">
        <table className="min-w-full divide-y divide-gray-300">
          <thead>
            <tr>
              <th
                scope="col"
                className="py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-0"
              >
                Workouts
              </th>
            </tr>
          </thead>
          <tbody className="divide-y divide-gray-200 bg-white">
            {workouts.map(workout => (
              <>
                <tr>
                  <td
                    className="whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-gray-700 sm:pl-0"
                    colSpan={5}
                  >
                    {`${workout.name} - ${new Date(workout.dateTime).toLocaleDateString()} - ${new Date(workout.dateTime).toLocaleTimeString()}`}{' '}
                  </td>
                </tr>
                {workout.sets && workout.sets.length > 0 ? (
                  <>
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
                    </tr>
                    {
                      // TODO: When mobile show the weight
                      // TODO: When mobile show the reps
                      // TODO: When mobile change color of row to indicate warmup/ working set
                      // TODO: When mobile show the edit button
                      // TODO: When mobile show the delete button
                    }
                    {workout.sets.map(set => (
                      <tr key={set.id}>
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
                      </tr>
                    ))}
                  </>
                ) : null}
              </>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
