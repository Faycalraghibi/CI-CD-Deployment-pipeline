#!/bin/bash

# Define container names
BLUE_CONTAINER=app-blue
GREEN_CONTAINER=app-green

# Function to check if a container is running
is_running() {
  docker ps -q -f name=$1
}

# Deploy to the inactive container
if is_running ${BLUE_CONTAINER}; then
  # Blue is running, deploy to green
  docker-compose up -d app-green
  NEW_CONTAINER=${GREEN_CONTAINER}
  OLD_CONTAINER=${BLUE_CONTAINER}
else
  # Blue is not running, deploy to blue
  docker-compose up -d app-blue
  NEW_CONTAINER=${BLUE_CONTAINER}
  OLD_CONTAINER=${GREEN_CONTAINER}
fi

# Optionally, wait for the new container to be healthy (if health checks are configured)
# sleep 30

# Remove the old container
docker-compose stop ${OLD_CONTAINER}
docker-compose rm -f ${OLD_CONTAINER}

echo "Switched deployment to ${NEW_CONTAINER}"

