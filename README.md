# Survey Tool

The Survey Tool is a web application that allows users to easily create, distribute, and participate in surveys. It provides a user-friendly interface for designing surveys with various question types, collecting responses, and analyzing the results.

## Requirements

This application meets the following requirements, based on the provided case study:

*   **Survey Display:** Surveys are displayed at the URL `http://localhost:5173/surveys/[id]`, allowing users to access specific surveys by their ID.
*   **Question Rating:** As a team member, users can rate questions in an anonymous survey to give their opinion about teamwork, providing valuable feedback.
*   **Question Limit:** The user can rate 5 questions per survey.
*   **Data Storage:** Survey results, including user ratings, are stored in the database for analysis and reporting.
*   **Result Access:** The survey results can be viewed in the application's UI at `http://localhost:5173/surveys/[id]/results`. Additionally, the results are accessible via an API call to `http://localhost:8080/api/surveys/[id]/results`, which returns the data in JSON format, enabling easy integration with other systems or data analysis tools.

## Architecture / Tech Stack

*   **Backend:** Java 24, Spring Boot 3.4.5
*   **Database:** H2 (in-memory)
*   **Frontend:** Vue.js 3, Vite 5.2.4


# Survey Tool - Docker Setup Guide

This guide provides step-by-step instructions on how to set up and run the Survey Tool project using Docker and Docker Compose.

## Prerequisites

*   [Docker](https://docs.docker.com/get-docker/) installed on your system. Docker can be installed directly on your system or through WSL (Windows Subsystem for Linux).
*   [Docker Compose](https://docs.docker.com/compose/install/) installed on your system.

    If you are using WSL, ensure that Docker is running within your WSL environment. You can typically start Docker using the command:

    ```bash
    sudo service docker start
    ```

## Setup Instructions

1.  **Clone the repository:**

    ```bash
    git clone <repository_url>
    cd <repository_directory>
    ```

2.  **Build and run the application using Docker Compose:**

    ```bash
    docker-compose up --build
    ```

    This command will:

    *   Build the Docker images for the backend and frontend services.
    *   Start the backend, database (H2), and frontend containers.

3.  **Access the application:**

    *   **Frontend:** Open your web browser and navigate to `http://localhost:5173`.
    *   **Backend:** The backend API is available at `http://localhost:8080`.
    *   **H2 Database:** The H2 database console is available at `http://localhost:8082`. You may need to configure the JDBC URL to `jdbc:h2:mem:testdb` and use the default username `sa` with a blank password.

## Configuration

### Environment Variables

The application does not require any specific environment variables to be set.


## Troubleshooting

### Port Conflicts

If you encounter port conflicts (e.g., `port is already allocated`), you can:

*   Stop any other applications using the conflicting port.
*   Change the port mappings in the `docker-compose.yaml` file. For example, to change the frontend port to 8081, modify the `frontend` service definition:

    ```yaml
    frontend:
      # ...
      ports:
        - "8081:80"
    ```

    Then, access the frontend at `http://localhost:8081`.

### Database Connection Issues

If the backend fails to connect to the database, ensure that:

*   The database container (`db`) is running.
*   The database connection details in `backend/src/main/resources/application.properties` are correct.
*   The H2 JDBC URL is correctly configured in the H2 console.

### Frontend Build Issues

If the frontend fails to build, ensure that:

*   You have the correct version of Node.js and npm installed.
*   All frontend dependencies are installed by running `npm install` in the `frontend` directory (although this should be handled by the `docker-compose up --build` command).

### Backend Build Issues

If the backend fails to build, ensure that:

*   You have the correct version of Java and Maven installed.
*   All backend dependencies are resolved in `backend/pom.xml`.

## Additional Notes

*   The `docker-compose.yaml` file defines the services, networks, and volumes for the application.
*   The `backend/Dockerfile` and `frontend/Dockerfile` files contain the instructions for building the Docker images.
*   The backend is a Spring Boot application built with Maven.
*   The frontend is a Vue.js application built with Vite.

## Alternative Setup (Without Docker)

This section provides instructions on how to set up and run the Survey Tool project without using Docker.

### Prerequisites

*   [Java Development Kit (JDK) 24](https://www.oracle.com/java/technologies/javase-jdk24-downloads.html) installed on your system.
*   [Node.js](https://nodejs.org/) and [npm](https://www.npmjs.com/) installed on your system.

### Setup Instructions

1.  **Clone the repository:**

    ```bash
    git clone <repository_url>
    cd <repository_directory>
    ```

2.  **Build and run the backend:**

    ```bash
    cd backend
    ./mvnw spring-boot:run
    ```

    This command will start the Spring Boot application. You might need to run `mvn install` before running the application.

3.  **Build and run the frontend:**

    ```bash
    cd frontend
    npm install
    npm run dev
    ```

    This will install the frontend dependencies and start the development server. The frontend will be accessible at `http://localhost:5173`.

### Additional Notes

*   Ensure that the backend is running before accessing the frontend.
*   The H2 database will be created in-memory.