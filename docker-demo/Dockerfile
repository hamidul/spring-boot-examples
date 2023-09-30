# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-oracle

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container at /app
COPY build/libs/docker-demo-0.0.1-SNAPSHOT.jar /app/

# Specify the command to run on container start
CMD ["java", "-jar", "docker-demo-0.0.1-SNAPSHOT.jar"]
