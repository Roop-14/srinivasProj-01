FROM openjdk:17-alpine
ARG JAR_FILE=target/Payment-service-app.jar
COPY ${JAR_FILE} payment_docker_app.jar
ENTRYPOINT ["java", "-jar", "/payment_docker_app.jar"]
