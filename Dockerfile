# Stage 1: Build the Spring Boot app using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Package the application (skip tests to speed up build)
RUN mvn clean package -DskipTests

# Stage 2: Create a minimal runtime image
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the fat JAR from the build stage
COPY --from=build /app/target/RethinkDigitalSolutionContact.jar app.jar

# Expose Spring Boot default port


# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
