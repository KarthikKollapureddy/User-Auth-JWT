# User Authentication Service

---

- User Authentication is a backend service used for handling users registration and login and only allow logged in users to access secure end points using <b> JWT Token </b>
- To run this app in your local
  - 
    1. Install Java 17
    2. Update the application.properties file or pass values as Environment variables

- To run using Docker 
  - 
  1. Build image using execute below command within project dir
    ```
     docker build -t user-auth-service .
     ```
  2. To run the crated image
     ```
     docker run -p 8080:8080 user-auth-service
     ```
---
## Once App is running, Swagger for the application can be accessed from below link


- [swagger](http://localhost:8080/swagger-ui/index.html)