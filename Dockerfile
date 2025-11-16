# ==== 1. Build Stage ====
FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /app

# copy pom.xml and download dependencies (cache layer)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# copy rest of source and build
COPY src ./src
RUN mvn clean package -DskipTests

# ==== 2. Runtime Stage ====
FROM eclipse-temurin:17-jdk
WORKDIR /app

# copy jar from build stage
COPY --from=build /app/target/rang-audio-visual-backend-0.0.1-SNAPSHOT.jar app.jar

# expose backend port
EXPOSE 8080

# start the application
ENTRYPOINT ["java", "-jar", "app.jar"]

