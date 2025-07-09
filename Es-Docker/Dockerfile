# Usa OpenJDK 21 come base
FROM openjdk:21-jdk-slim

# Imposta la directory di lavoro
WORKDIR /app

# Copia il file JAR dell'applicazione
COPY target/quiz-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta 8080
EXPOSE 8080

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]
