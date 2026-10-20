FROM eclipse-temurin:27-jdk-alpine AS builder

WORKDIR /app

COPY ../.mvn .mvn/
COPY ../mvnw pom.xml ./
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

COPY ../src src/
RUN ./mvnw clean package -DskipTests -B

FROM eclipse-temurin:27-jre-alpine

WORKDIR /app

RUN addgroup -S spring && adduser -S spring -G spring

COPY --from=builder /app/target/*.jar app.jar

USER spring:spring

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]