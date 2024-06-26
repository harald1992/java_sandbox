# Docker
mvn spring-boot:build-image

# if locally built, docker compose will fetch that, otherwise you need to puck docker image
docker image push docker.io/harald1992/onsen-auth-service:0.0.1

docker run -d -p 8082:8082 --platform linux/amd64 --network=host -e SPRING_PROFILES_ACTIVE=prod harald1992/onsen-main:0.0.1
