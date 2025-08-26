FROM openjdk:17-alpine
ARG JAR_FILE=target/eureka-server.jar
COPY ${JAR_FILE} eureka-server_docker_app.jar
ENTRYPOINT ["java", "-jar", "/eureka-server_docker_app.jar"]
