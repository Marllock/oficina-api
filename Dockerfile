FROM maven:3-eclipse-temurin-18-alpine AS build

WORKDIR /home

COPY src ./src
COPY pom.xml .
RUN ./mvnw clean package

FROM openjdk:18-jdk-alpine3.15
EXPOSE 8080
COPY --from=build ./target/... app.jar
ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.datasource.url=", "--spring.datasource.username=", "--spring.datasource.password="]



