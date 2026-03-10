# Use a slim Java base image with JDK 17
FROM openjdk:17.0.2-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/vehicles-0.0.1-SNAPSHOT.jar vehicles-app.jar

# Expose the port on which the Spring Boot app runs
EXPOSE 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "vehicles-app.jar"]