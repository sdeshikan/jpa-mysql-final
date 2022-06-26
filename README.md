# Accessing data with MySQL using Spring Data JPA in 15 minutes

GET: http://localhost:8080/users -- returns list of all users

POST: http://localhost:8080/users -- create new user

  {
    "name": "Adaline Reichel",
    "email": "Adaline.Reichel@gmail.com"
  }

PUT: http://localhost:8080/users/12 -- update user
{
    "id": 12,
    "name": "Adaline Reichel",
    "email": "Adaline.Reichel@gmail.com"
  }

DELETE: http://localhost:8080/users/12 -- delete user

## Outcomes:
MySQL database, build a Spring application, and connect it to the newly created database.

## Tools and technologies used:

Java 17
Spring Boot
Spring Data JPA ( Hibernate)
Lombok
MySQL
VS Code
Maven
Tomcat
Thunder Client / Postman
