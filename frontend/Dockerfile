# Use the official Node.js LTS image as base
FROM node:lts-alpine as builder

# Set working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package.json package-lock.json ./

# Install dependencies using npm
RUN npm install

# Copy the entire project
COPY . .

# Build the app
RUN npm run build

# Expose port 80
EXPOSE 80

# Command to run the application
CMD [ "npm", "run", "preview" ]
