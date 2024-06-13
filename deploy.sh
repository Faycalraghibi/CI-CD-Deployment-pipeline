#!/bin/bash

# Build the Docker image
docker build -t spring-example:latest .

# Determine which color is currently deployed
CURRENT_COLOR=$(docker ps --filter "name=spring-app" --format "{{.Names}}" | grep -E 'spring-app-(blue|green)' | awk -F '-' '{print $NF}')

if [ "$CURRENT_COLOR" == "blue" ]; then
  IDLE_COLOR="green"
  IDLE_PORT="8082"
else
  IDLE_COLOR="blue"
  IDLE_PORT="8081"
fi

# Deploy the new version
docker-compose up -d --build spring-app-$IDLE_COLOR

# Wait for the new version to be healthy
sleep 30

# Switch the load balancer (or the reverse proxy) to the new version
# This depends on your setup, for example, you might use an Nginx or HAProxy config here

# Stop the old version
if [ "$CURRENT_COLOR" != "" ]; then
  docker-compose stop spring-app-$CURRENT_COLOR
fi

# Remove old containers
docker-compose rm -f spring-app-$CURRENT_COLOR

