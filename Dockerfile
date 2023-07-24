FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Runtime stage
FROM adoptopenjdk:17-jre-hotspot-slim
COPY --from=build /app/target/myapp.jar /myapp.jar
EXPOSE 8080
CMD ["java", "-jar", "/myapp.jar"]
