1. Kubernetes
    Kubernetes verwaltet deine gesamte Anwendung – also das Vehicle-Backend und die PostgreSQL-Datenbank.
    Es sorgt dafür, dass beide Komponenten immer laufen, miteinander kommunizieren können und bei Problemen automatisch neu gestartet werden.

2. Pod
    Vehicle-Backend-Pod:
        Ein Pod enthält deinen Backend-Container (z. B. das Spring Boot-Backend für Fahrzeuge).
    PostgreSQL-Pod:
        Ein weiterer Pod enthält die PostgreSQL-Datenbank als Container.
        Jeder Pod ist eine eigene, isolierte Umgebung für einen Teil deiner Anwendung.

3. Deployment
    Vehicle-Backend-Deployment:
        Das Deployment beschreibt, wie viele Instanzen (Pods) deines Backends laufen sollen (z. B. 1 oder mehrere für Lastverteilung).
        Es sorgt dafür, dass bei einem Update automatisch neue Versionen ausgerollt werden und alte entfernt werden.
        PostgreSQL-Deployment (optional):
        Auch für die Datenbank kann ein Deployment genutzt werden, meist läuft sie aber als StatefulSet (für dauerhafte Daten).

4. Service
    Vehicle-Backend-Service:
        Der Service gibt deinem Backend eine feste Adresse im Cluster.
        Wenn du z. B. /api/vehicles aufrufst, leitet der Service die Anfrage an den richtigen Pod weiter – egal, wie oft dieser neu gestartet wird.
    PostgreSQL-Service:
        Der Service sorgt dafür, dass das Backend immer die Datenbank unter einem festen Namen (z. B. postgres) erreichen kann, auch wenn der Datenbank-Pod neu startet.


[User/Browser]
     |
     v
[Vehicle-Backend-Service] ---> [Vehicle-Backend-Pod]
                                   |
                                   v
                        [PostgreSQL-Service] ---> [PostgreSQL-Pod]





Self-Healing:
Wenn ein Pod (also ein Teil deiner Anwendung, z.B. das Vehicle-Backend oder die Datenbank) abstürzt oder gelöscht wird, erkennt Kubernetes das automatisch.
Neustart:
Kubernetes startet den Pod sofort neu, damit die gewünschte Anzahl immer läuft.
Ausfallsicherheit:
Deine Anwendung bleibt verfügbar, auch wenn einzelne Teile ausfallen.


Docker Compose:
Kein automatischer Neustart:
Wenn ein Container abstürzt, bleibt er gestoppt, bis du ihn manuell neu startest (docker-compose restart).
Weniger Ausfallsicherheit:
Die Anwendung kann ausfallen, wenn ein Container stoppt und niemand ihn neu startet.
Es gibt zwar die Option restart: always in Docker Compose, aber das funktioniert nur auf dem Host und ist nicht so zuverlässig und flexibel wie Kubernetes.