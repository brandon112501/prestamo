# Etapa 1: Compilar el proyecto con Maven oficial
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar la aplicación con una imagen ligera de Java
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "app.jar"]", "target/*.jar"]estamo-0.0.1-SNAPSHOT.jar"]