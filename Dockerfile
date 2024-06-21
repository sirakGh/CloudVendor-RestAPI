# Use a base image with Java
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the host machine to the working directory
COPY target/rest-demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Define the command to run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

