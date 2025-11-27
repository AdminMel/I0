# ============================
# Etapa 1: Build con Maven
# ============================
FROM maven:3.9-eclipse-temurin-21 AS build

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el descriptor de dependencias primero (para cachear mejor)
COPY pom.xml .

# Descarga de dependencias (sin compilar todavía)
RUN mvn -q -e -DskipTests dependency:go-offline

# Copiamos el código fuente
COPY src ./src

# Empaquetamos la aplicación (jar)
RUN mvn -q -DskipTests package

# ============================
# Etapa 2: Imagen ligera para runtime
# ============================
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiamos el JAR desde la etapa de build
# Ajusta el nombre del jar si tu proyecto genera otro distinto
COPY --from=build /app/target/*.jar app.jar

# Puerto en el que corre tu Spring Boot (por defecto 8080)
EXPOSE 8080

# Variables de entorno opcionales (puedes sobreescribirlas en docker-compose)
ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
