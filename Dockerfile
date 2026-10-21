# Etapa 1: Compilar el proyecto con Maven y Java 21 oficial
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar la aplicación con una imagen ligera de Java 21
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]"app.jar"]", "target/*.jar"]estamo-0.0.1-SNAPSHOT.jar"]