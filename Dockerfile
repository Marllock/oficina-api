FROM maven:3-eclipse-temurin-19-alpine AS build

COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:19-jdk-alpine
EXPOSE 8080
COPY --from=build /home/app/target/educational-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.datasource.url=jdbc:postgresql://postgres:5432/oficina-1?serverTimezone=America/Sao_Paulo&useLegacyDatetimeCode=false", "--spring.datasource.username=teste", "--spring.datasource.password=teste"]



