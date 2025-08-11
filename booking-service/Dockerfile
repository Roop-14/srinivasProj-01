FROM openjdk:17-alpine
ARG JAR_FILE=target/Booking-service-app.jar
COPY ${JAR_FILE} booking_docker_app.jar
ENTRYPOINT ["java", "-jar", "/booking_docker_app.jar"]
