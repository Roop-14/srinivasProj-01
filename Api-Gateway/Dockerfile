FROM openjdk:17-alpine
ARG JAR_FILE=target/Api-gateway-app.jar
COPY ${JAR_FILE} Api-gateway-docker_app.jar
ENTRYPOINT ["java", "-jar", "/Api-gateway-docker_app.jar"]
