#!/bin/bash

# Shut down all Docker containers
docker-compose down

# Remove Docker volumes
docker volume rm e-commerce-db-data

# Start Docker containers for databases
docker-compose up -d postgres

# Wait for the containers to be healthy
echo "Waiting for containers to be healthy..."
while true; do
    if docker ps --filter "health=healthy" --format "{{.Names}}" | grep -q "postgres"
    then
        echo "Containers are healthy."
        break
    else
        echo "Container are not healthy yet. Waiting..."
        sleep 5
    fi
done

# Wait for PostgreSQL to be ready to accept connections
echo "Waiting for PostgreSQL to be ready..."
docker-compose run --rm postgres bash -c "while ! pg_isready -h postgres -U postgres -q -t 1; do sleep 5; done"

echo "Containers are not healthy yet. Waiting..."

# Run MyBatis generator for each module
echo "Generating MyBatis files for ECom-admin"
cd ./ECom-admin
mvn mybatis-generator:generate -Dmybatis.generator.overwrite=true
cd ..

echo "Generating MyBatis files for ECom-app/App"
cd ./ECom-app
mvn mybatis-generator:generate -Dmybatis.generator.overwrite=true
cd ..

echo "MyBatis generation completed for all modules"
