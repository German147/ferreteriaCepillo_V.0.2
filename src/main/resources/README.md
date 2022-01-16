# <h1> Customer  Desktop Control Application</h1>
###### Desktop application created with SpringBoot, and Postgresql relational database
<br/>

### Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
I take it as my own challenge, I am trying to make a desktop application using SpringBoot.  THre are plenty of examples
on how to make a web application , but not many on how to make a Desktop application using SpringBoot.
This is an application to put into practice what I have learnt over the courses I did during this time. Nowadays I am
working on it 16/01/2022.


### Technologies and dependencies


````
* Java 11
* Spring Boot version: 2.6.1
* Spring Web
* Spring Security
* Devtools
* Validation
* Guava version 28.1-jre
* Jpa
* Thymeleaf
* PostgreSQL
* Lombok
````

## Setup
To run this project, install it locally, open it into your IDE, go to the dbConfig package, DBConfig Class and then 
change the database configuration like driver, Url, db name, user and password. Finally, run it as any other java 
application. 

```
   dataSourceBuilder.driverClassName("org.postgresql.Driver");
   dataSourceBuilder.url("jdbc:postgresql://localhost:5432/dbName");
   dataSourceBuilder.username("username");
   dataSourceBuilder.password("password");
```

### Author
This repository was built using documentation on the internet.

* **Barrera Luis German**  - *Java Developoer*




 
 


