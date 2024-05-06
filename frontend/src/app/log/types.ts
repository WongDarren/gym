export interface Set {
  id: number;
  dateTime: string;
  workoutId: number;
  setNumber: number;
  weight: number;
  reps: number;
  rpe: number;
}

export interface Workout {
  id: number;
  name: string;
  dateTime: string;
  sets: Set[];
}
