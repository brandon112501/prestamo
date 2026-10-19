FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

# Dar permisos al mvnw y compilar el proyecto con Maven
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

EXPOSE 8083

CMD ["java", "-jar", "target/*.jar"]estamo-0.0.1-SNAPSHOT.jar"]