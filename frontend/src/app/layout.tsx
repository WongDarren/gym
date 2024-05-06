import type { Metadata } from 'next';
import { Inter } from 'next/font/google';
import './globals.css';
import { type ReactNode } from 'react';
import { Toaster } from '@/components/ui/toaster';

const inter = Inter({ subsets: ['latin'] });

export const metadata: Metadata = {
  title: 'Gym App',
  description: 'App for tracking workouts and progress'
};

export default function RootLayout({
  children
}: Readonly<{
  children: ReactNode;
}>) {
  return (
    <html lang="en">
      <body className={inter.className}>
        <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
          <div className="mx-auto max-w-6xl">
            <main>{children}</main>
            <Toaster />
          </div>
        </div>
      </body>
    </html>
  );
}
