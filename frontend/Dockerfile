# Use the official Node.js LTS Alpine image as the base image
FROM node:lts-alpine AS base

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package.json package-lock.json* ./

# Install dependencies using npm
RUN npm ci

# Copy the rest of your application's source code
COPY . .

# Build the application
RUN npm run build

# Expose port 3000 for the application
EXPOSE 3000

# Start the application
CMD ["npm", "run", "start"]