# Docker
mvn spring-boot:build-image

# if locally built, docker compose will fetch that, otherwise you need to puck docker image
docker image push docker.io/harald1992/onsen-auth-service:0.0.1
