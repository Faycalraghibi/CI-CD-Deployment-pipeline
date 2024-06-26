# CI/CD Deployment Pipeline for Spring Boot Application

This repository contains a CI/CD deployment pipeline setup for a Spring Boot application. The pipeline is configured with Jenkins and Docker to automate the build, test, and deployment processes.

## Project Structure

The project structure is as follows:

```
CI-CD-Deployment-pipeline/
├── Jenkinsfile
├── deploy.sh
├── docker-compose.yml
├── Dockerfile
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/
    │   │   └── Spring/
    │   │       └── example/
    │   │           ├── customer/
    │   │           │   ├── CustomerController.java
    │   │           │   ├── CustomerDao.java
    │   │           │   ├── Customer.java
    │   │           │   ├── CustomerJPADataAccessService.java
    │   │           │   ├── CustomerListDataAccessService.java
    │   │           │   ├── CustomerRegistrationRequest.java
    │   │           │   ├── CustomerRepository.java
    │   │           │   ├── CustomerService.java
    │   │           │   └── ResourceNotFound/
    │   │           │       ├── DuplicateResourceExeption.java
    │   │           │       └── ResourceNotFound.java
    │   │           └── Main.java
    │   └── resources/
    │       └── application.yml
    └── test/
        └── java/
```

## Tools and Technologies Used

- **Jenkins**: Automation server for continuous integration and continuous deployment (CI/CD).
- **Docker**: Containerization platform used to package the application and its dependencies into a Docker image.
- **Java Development Kit (JDK)**: Required for compiling and running the Java application.
- **Apache Maven**: Build automation tool used primarily for Java projects to manage dependencies and build the project.
- **Spring Boot**: Framework used to create stand-alone, production-grade Spring-based applications.

## Setup Instructions

### Prerequisites

Ensure the following tools are installed on your machine:

- Docker
- JDK (Java Development Kit)
- Apache Maven

### Running the Application Locally

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/Faycalraghibi/CI-CD-Deployment-pipeline.git
   cd CI-CD-Deployment-pipeline
   ```

2. **Build the Project:**

   ```bash
   ./mvnw clean package
   ```

3. **Build Docker Image:**

   ```bash
   docker build -t spring-example:latest .
   ```

4. **Run Docker Compose (for local testing):**

   ```bash
   docker-compose up
   ```

5. **Access the Application:**

   Open a web browser and go to `http://localhost:8080`.

## Jenkins Pipeline Configuration

The Jenkins pipeline is configured in `Jenkinsfile` and includes stages for:

- **Checkout**: Fetching the latest source code from the repository.
- **Build**: Building the Spring Boot application using Maven.
- **Build Docker Image**: Creating a Docker image of the application.
- **Push Docker Image**: Pushing the Docker image to Docker Hub.
- **Deploy**: Running deployment scripts or commands (e.g., deploying to a server).

Ensure Jenkins is configured with the necessary plugins for Docker integration and Maven.

## Continuous Integration and Deployment

The pipeline is triggered automatically on commits to the `main` branch. Adjust the `Jenkinsfile` as needed for additional branches or specific triggers.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or a pull request.
