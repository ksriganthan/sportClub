# Sport Club Management System

Ein Spring Boot Demo-Projekt zur Verwaltung von Sportclubs mit Teams, Spielern, Trainern, Stadien und Skills.

## 📋 Projektbeschreibung

Dieses Projekt demonstriert die Struktur und gängige Praktiken von Spring Boot Anwendungen. Es implementiert ein vollständiges Sport Club Management System mit RESTful APIs zur Verwaltung von:

- **Teams** - Fußballmannschaften mit Budget
- **Spieler** - Spieler mit Skills und Zuordnung zu Teams
- **Trainer (Coaches)** - Trainer mit Beziehungen zu Spielern und Teams
- **Stadien** - Spielstätten mit Name und Ort
- **Skills** - Verschiedene Fähigkeitstypen (Technik, Physik, Mental, etc.)
- **Player Skills** - Bewertung der Spielerfähigkeiten

## 🛠️ Technologie-Stack

- **Java 25**
- **Spring Boot 3.5.7**
- **Spring Data JPA** - Datenbankzugriff
- **Spring Web** - RESTful API
- **H2 Database** - In-Memory Datenbank
- **Maven** - Build Management

## 📦 Dependencies

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## 🚀 Installation & Start

### Voraussetzungen

- Java 25 oder höher
- Maven 3.x

### Projekt starten

1. Repository klonen
```bash
git clone https://github.com/ksriganthan/sportClub.git
cd sportClub
```

2. Mit Maven Wrapper starten (Linux/Mac)
```bash
./mvnw spring-boot:run
```

Oder für Windows:
```bash
mvnw.cmd spring-boot:run
```

3. Alternativ: JAR bauen und ausführen
```bash
./mvnw clean package
java -jar target/sportClub-0.0.1-SNAPSHOT.jar
```

Die Anwendung startet standardmäßig auf `http://localhost:8080`

## 📊 Datenmodell

### Entities

- **Coach** - Trainer mit Name, Teams und Spieler-Liste
- **Player** - Spieler mit Name, Coach und aktuellem Team
- **Team** - Mannschaft mit Name, Budget, Spielern und Trainern
- **Stadium** - Stadion mit Name und Ort
- **Skill** - Fähigkeitstypen (Technic, Physic, Mental, Defence, Attack, Keeper)
- **PlayerSkill** - Verknüpfung zwischen Spieler und Skill mit Rating (0-100)

### Beziehungen

- `Coach` ↔ `Player` (1:n)
- `Coach` ↔ `Team` (m:n)
- `Player` ↔ `Team` (n:1)
- `Player` ↔ `Skill` über `PlayerSkill` (m:n mit Attribut)
- `Team` ↔ `Stadium` (1:1)

## 🔌 API Endpoints

### Stadiums

```
GET    /stadiums           - Alle Stadien abrufen
GET    /stadiums/{id}      - Einzelnes Stadion abrufen
PUT    /stadiums/{id}      - Stadion aktualisieren
```

### Weitere Endpoints

Das Projekt enthält Controller für:
- Teams
- Spieler
- Trainer
- Skills
- Player Skills

## 💾 Testdaten

Die Anwendung lädt beim Start automatisch Testdaten über die `LoadDatabase` Komponente:

**Beispieldaten:**
- Trainer: Pep Guardiola, Jose Mourinho
- Spieler: Lionel Messi, Cristiano Ronaldo
- Teams: FC Barcelona, Real Madrid
- Skills: Technic, Physic, Mental, Defence, Attack, Keeper
- Player Skills mit Ratings (0-100)

## 🗄️ H2 Datenbank Console

Die H2 Console ist verfügbar unter: `http://localhost:8080/h2-console`

**Verbindungsdetails:**
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leer lassen)

## 📝 Projektstruktur

```
src/
├── main/
│   ├── java/org/fhnw/sport/sportclub/
│   │   ├── Coach/              - Coach Entity, Repository, Controller
│   │   ├── Player/             - Player Entity, Repository, Controller
│   │   ├── Team/               - Team Entity, Repository, Controller
│   │   ├── Stadium/            - Stadium Entity, Repository, Controller
│   │   ├── Skill/              - Skill Entity, Repository, SkillType Enum
│   │   ├── PlayerSkill/        - PlayerSkill Entity, Repository, Key
│   │   ├── Pet/                - Pet Entity, Repository, Controller
│   │   ├── config/             - LoadDatabase (Testdaten)
│   │   └── SportClubApplication.java
│   └── resources/
└── test/
    └── java/org/fhnw/sport/sportclub/
```

## 🎯 Features

- ✅ RESTful API Architektur
- ✅ JPA/Hibernate für ORM
- ✅ Bidirektionale Beziehungen (OneToMany, ManyToMany, OneToOne)
- ✅ JSON Serialisierung mit Jackson (`@JsonIdentityInfo`, `@JsonManagedReference`)
- ✅ Exception Handling (Custom NotFoundExceptions)
- ✅ Automatisches Laden von Testdaten
- ✅ H2 In-Memory Datenbank
- ✅ Composite Keys für Join-Tabellen

## 🧪 Testing

Tests ausführen:
```bash
./mvnw test
```

## 📖 Lernziele

Dieses Demo-Projekt vermittelt:
- Spring Boot Grundstruktur
- RESTful API Design
- JPA Entity Relationships
- Repository Pattern
- Dependency Injection
- Transaction Management
- Exception Handling
- Maven Build Management

## 👤 Autor

**FHNW Sport Club Project**
- Organization: `org.fhnw.sriganthan`
- Repository: [ksriganthan/sportClub](https://github.com/ksriganthan/sportClub)

## 📄 Lizenz

Dieses Projekt dient zu Lern- und Demonstrationszwecken.
