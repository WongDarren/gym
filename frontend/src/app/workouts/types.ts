export interface Set {
  id: number;
  dateTime: string;
  workoutId: number;
  setNumber: number;
  weight: number;
  reps: number;
  rpe: number;
  warmup: boolean;
}

export interface Workout {
  id: number;
  name: string;
  dateTime: string;
  sets: Set[];
}
