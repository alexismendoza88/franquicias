# Usar imagen base de OpenJDK
FROM openjdk:17-jdk-slim AS build

# Directorio de trabajo
WORKDIR /app

# Copiar el jar empaquetado
COPY franquicias-app.jar franquicias-app.jar

# Exponer el puerto (por defecto 8080)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "franquicias-app.jar"]
