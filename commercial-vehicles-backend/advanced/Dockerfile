# Basis-Image für Java-Anwendungen
FROM amazoncorretto:17

# Arbeitsverzeichnis im Container erstellen
WORKDIR /app

# PostgreSQL installieren
RUN yum update -y && yum install -y postgresql

# Spring Boot JAR-Datei kopieren
COPY build/libs/vehicles-0.0.1-SNAPSHOT.jar vehicles-app.jar

# Port freigeben
EXPOSE 8080
EXPOSE 5432

# Startskript erstellen
RUN echo "#!/bin/bash\n\
service postgresql start\n\
java -jar /app/vehicles-app.jar" > /app/start.sh && chmod +x /app/start.sh

# Startskript ausführen
ENTRYPOINT ["/bin/bash", "/app/start.sh"]