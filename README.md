# Battleship Game

## Beschreibung
Dieses Projekt ist eine einfache Umsetzung des **Schiffe versenken (Battleship)** Spiels als REST-API mit **Spring Boot**. Zwei Spieler können Schiffe auf einem Spielfeld platzieren und dann versuchen, die Schiffe des Gegners zu treffen.

## Anforderungen
- **Java 17** 
- **Spring Boot 3**
- **Gradle**
- **H2-Datenbank (in-memory)**
- **Postman oder Swagger UI** für API-Tests

## Features
- Erstellen eines Spiels
- Hinzufügen und Verwalten von Spielern
- Platzieren von Schiffen
- Raten von Schiffspositionen
- Anzeige des aktuellen Spielstands

## API Endpunkte
Die Anwendung stellt REST APIs zur Verfügung. Die OpenAPI-Dokumentation befindet sich unter:
```
http://localhost:8080/swagger-ui.html
```
## Postman Tests
- Spiel erstellen: POST http://localhost:8080/api/games | GET http://localhost:8080/api/games/1
- Spieler erstellen: POST http://localhost:8080/players?name=Smigul
- Schiff platzieren: POST http://localhost:8080/api/games/1/ships?playerId=1&x=2&y=3&length=3&direction=HORIZONTAL
- Angriff auf eine Position: POST http://localhost:8080/api/games/1/guess?playerId=1&x=2&y=3
- Spielstatus abrufen: GET http://localhost:8080/api/games/1
- Spielende überprüfen: POST http://localhost:8080/api/games/1/guess?playerId=1&x=3&y=3




## Autor
- **Simge Sayginsoy**
