# Utiliser l'image de base adoptopenjdk pour Java 17
FROM openjdk:17
# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR de l'application dans le conteneur
COPY build/libs/*.jar app.jar

# Exposer le port sur lequel l'application s'exécute
EXPOSE 8080

# Commande pour exécuter l'application Spring Boot lorsque le conteneur démarre
CMD ["java", "-jar", "app.jar"]
