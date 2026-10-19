# Usar una imagen oficial de Java (OpenJDK)
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar los archivos de gradle y código fuente
COPY . .

# Dar permisos de ejecución al gradle wrapper y compilar el proyecto
RUN chmod +x gradlew
RUN ./gradlew build -x test

# Exponer el puerto que usará la aplicación en Render
EXPOSE 8083

# Comando para ejecutar el archivo JAR generado
CMD ["java", "-jar", "build/libs/prestamo-0.0.1-SNAPSHOT.jar"]