'use client';

import { useEffect, useState } from 'react';

interface Fruit {
  name: string;
  description: string;
}

export default function Fruits() {
  const [fruits, setFruits] = useState<Fruit[]>([]);
  useEffect(() => {
    fetch('http://localhost:8080/api/fruits')
      .then(res => res.json())
      .then((data: Fruit[]) => {
        setFruits(data);
      })
      .catch((error: unknown) => {
        console.error('Error:', error);
      });
  }, []);

  return (
    <div>
      <div className="container">
        <h2 className="ml-8 text-lg font-semibold">Fruits</h2>
        <div className="container flex justify-between">
          {fruits.map(fruit => (
            <div
              key={fruit.name}
              className="m-4 flex flex-col rounded-lg bg-gray-100 p-4"
            >
              <h3 className="text-lg font-semibold">{fruit.name}</h3>
              <p>{fruit.description}</p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
