#!/bin/bash

# Run Docker Compose
docker-compose up -d

# Build Docker image
docker build . -t 'onsen-auth-service'

# Run Docker container
docker run -p 8081:8081 --network=host onsen-auth-service

