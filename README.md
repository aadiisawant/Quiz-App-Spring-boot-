# Quiz App - Microservices Architecture

Welcome to the Quiz App, a Spring Boot-based application designed using the Microservices architecture. This application is comprised of multiple services that work together to provide quiz creation and management functionalities.

## Services

### 1. Discovery Service (Eureka Client)
- **Module Name:** discovery-service
- **Description:** This service functions as the Eureka client for service discovery within the microservices architecture.

### 2. API Gateway Service
- **Module Name:** API-GATEWAY
- **Description:** The API Gateway service serves as the entry point for external clients, routing requests to the appropriate microservices and handling authentication and authorization.

### 3. Quiz Service
- **Module Name:** QUIZ-APP
- **Description:** Responsible for the creation and management of quizzes. This service interacts with the database to store and retrieve quiz information.

### 4. Question App Service
- **Module Name:** QUESTION-APP
- **Description:** Handles CRUD operations related to questions. This service communicates with the database to manage question data.

## Database
- **Database:** MySQL
- **Schema:** The application uses a MySQL database to store quiz and question information.

## Getting Started

### Prerequisites
- Ensure you have Java installed.
- Set up MySQL database and update the application properties accordingly.
- Maven for building and managing dependencies.

### Build and Run
1. Clone the repository: `git clone https://github.com/aadiisawant/Quiz-App-Spring-boot-.git`
2. Navigate to each service directory and build using Maven: `mvn clean install`
3. Run each service individually, starting with the discovery service.

### Service Ports
- Discovery Service: `8024`
- API Gateway Service: `8763`
- Quiz Service: `8080`
- Question App Service: `8282`

### API Testing
- To understand the available API endpoints and their functionalities, it is recommended to review the source code of each service located in their respective directories. Additionally, check the service-specific controllers for information on supported endpoints and their expected request and response formats.
- For testing the APIs and fetching data, it is recommended to use a tool like [Postman](https://www.postman.com/) or any other API testing tool of your preference. Postman provides a user-friendly interface for sending requests, exploring APIs, and inspecting responses.


## Additional Information
- This application is designed to showcase microservices architecture using Spring Boot.
- Each service is modular and can be scaled independently.
- For any issues or suggestions, please raise a GitHub issue.

## Author
- Aditya Chandrakant Sawant


## License
This project is licensed under the [MIT License](LICENSE).

