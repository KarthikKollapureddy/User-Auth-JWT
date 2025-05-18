# Stage 1: Use Gradle image to build the application
FROM gradle:7.5-jdk17 AS build
ARG SECRET="566B59703373367638792F423F4528482B4D6251655468576D5A713474377721"

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper, project files, and source code into the container
COPY gradlew gradlew.bat build.gradle settings.gradle ./
COPY gradle ./gradle
COPY src ./src

# Ensure the Gradle wrapper is executable
RUN chmod +x gradlew

# Run the Gradle build (skip tests for faster build)
RUN ./gradlew clean build -x test --no-daemon --stacktrace

# Stage 2: Use a lightweight JDK runtime image to run the application
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the port the Spring Boot app runs on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
