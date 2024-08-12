### AKS Set Up for React UI and Node API ###

### Create UI(React) ###
```
npx create-react-app my-app
cd my-app
npm start
```
### Create a Dockerfile for React UI ###

- Filename "Dockerfile"
- Paste following contents to "Dockerfile"
```
# Step 1: Use Node.js as the base image
FROM node:18 AS build

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy package.json and package-lock.json
COPY package*.json ./

# Step 4: Install dependencies
RUN npm install

# Step 5: Copy the rest of the application code
COPY . .

# Step 6: Build the React app
RUN npm run build

# Step 7: Use a lightweight web server to serve the build
FROM nginx:alpine

# Step 8: Copy build artifacts from the build stage
COPY --from=build /app/build /usr/share/nginx/html

# Step 9: Expose port 80
EXPOSE 80

# Step 10: Start Nginx server
CMD ["nginx", "-g", "daemon off;"]


```

### Build Image with version 1 ###
```
docker build -t my-app:1 .

```

### Run the image ###

```
docker run -p 3000:80 my-app:1

```
