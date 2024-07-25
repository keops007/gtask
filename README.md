# TaskManager

## Overview

**TaskManager** is a Java Spring Boot application that manages a simple to-do list. The application allows users to perform CRUD operations on tasks, including creating, viewing, and updating tasks. The data is stored in a PostgreSQL database, and Liquibase is used for database schema management.

## Features

- **Create Task**: Allows adding tasks with a title and description.
- **View Tasks**: Allows viewing all existing tasks.
- **Update Task**: Allows updating the status (completed or not) and description of a task.

## Technologies and Tools

- **Java 11**
- **Spring Boot 2.7**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL**
- **Liquibase**
- **Maven**

## Project Structure


## Getting Started

### Prerequisites

- Java 11
- Maven
- PostgreSQL

### Installation

1. **Clone the repository:**

    ```sh
    git clone https://github.com/your-username/TaskManager.git
    cd taskmanager
    ```

2. **Configure PostgreSQL:**

   Ensure PostgreSQL is installed and running. Create a database and a user.

    ```sql
    CREATE DATABASE taskdb;
    CREATE USER yourusername WITH PASSWORD 'yourpassword';
    GRANT ALL PRIVILEGES ON DATABASE taskdb TO yourusername;
    ```

3. **Configure application.properties:**

   Update the `src/main/resources/application.properties` file with your PostgreSQL credentials.

    ```properties
    # Database configuration
    spring.datasource.url=jdbc:postgresql://localhost:5432/taskdb
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword

    # Hibernate settings
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```

4. **Run the application:**

    ```sh
    mvn spring-boot:run
    ```

## Usage

### Endpoints

1. **POST /api/tasks**

   Creates a new task.

    ```sh
    curl -X POST http://localhost:8080/api/tasks -H "Content-Type: application/json" -d '{"title": "New Task", "description": "Task description"}'
    ```

2. **GET /api/tasks**

   Retrieves all tasks.

    ```sh
    curl -X GET http://localhost:8080/api/tasks
    ```

3. **PUT /api/tasks/{id}**

   Updates a task's status and description.

    ```sh
    curl -X PUT http://localhost:8080/api/tasks/{id} -H "Content-Type: application/json" -d '{"completed": true, "description": "Updated description"}'
    ```

## Database Schema

**tasks Table**

| Column      | Type        |
|-------------|-------------|
| id          | INT         |
| title       | VARCHAR     |
| description | TEXT        |
| completed   | BOOLEAN     |
| created_at  | TIMESTAMP   |
| updated_at  | TIMESTAMP   |

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>taskmanager</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.0</version>
        <relativePath/>
    </parent>

    <dependencies>
        <!-- Spring Boot dependencies -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

        <!-- JPA (Jakarta Persistence API) dependency -->
        <dependency>
            <groupId>jakarta.persistence</groupId>
            <artifactId>jakarta.persistence-api</artifactId>
            <version>3.0.0</version>
        </dependency>

        <!-- Hibernate (as the JPA implementation) -->
        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>6.0.0.Final</version>
        </dependency>

        <!-- Optional: Lombok for boilerplate code reduction -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.24</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.10.1</version>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
