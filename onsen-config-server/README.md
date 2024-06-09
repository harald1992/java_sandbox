[//]: # (Run RabbitMQ)

[//]: # (# latest RabbitMQ 3.13)

[//]: # (docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.13-management)


mvn spring-boot:build-image
docker run -d -p 8071:8071 harald1992/onsen-config-server:0.0.1
docker run -d -p 8071:8071 -e SPRING_RABBITMQ_HOST=rabbitmq harald1992/onsen-config-server:0.0.1


Get environments
#  http://localhost:8071/onsen-eureka-server/prod
