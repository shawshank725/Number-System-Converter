# Use Java 22 (since you compiled with Java 22)
FROM openjdk:22

# Set working directory
WORKDIR /opt

# Set environment variable for the port
ENV PORT=8080

# Expose the port
EXPOSE 8080

# Copy the JAR file from the target directory
COPY target/*.jar /opt/app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
