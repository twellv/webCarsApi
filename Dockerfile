FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:17-alpine
COPY --from=build /app/target/artifact.demo-0.0.1-SNAPSHOT.jar /artifact.demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "/artifact.demo-0.0.1-SNAPSHOT.jar"]
