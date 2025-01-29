# Etapa de construcción (build)
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copiar el archivo pom.xml y descargar dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el código fuente
COPY src ./src

# Construir el proyecto (sin ejecutar pruebas para agilizar el build)
RUN mvn package -DskipTests

# Etapa de ejecución (runtime)
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiar el archivo .jar generado en la primera etapa
COPY --from=build /app/target/mi-coleccion-1.0-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
