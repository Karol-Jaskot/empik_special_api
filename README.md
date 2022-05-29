# Empik special api

Secret project

A small project of a simple API in Java technology

* Author: Karol Jaskot
* E-mail: karol.jaskot@wp.pl

## Deployment

This project is hosted and ready to use.  
App adress:
http://www.karol-jaskot.pl:8083/swagger-ui/

App status: [![Build Status](http://145.239.88.239:8085/buildStatus/icon?job=empik_special_api)](http://145.239.88.239:8085/job/empik_special_api/)

### Application building stages:

Java App -> Github Repo -> Github WebHook -> Jenkins -> Docker Image -> Container On Server


## Tech

* SpringBoot
* Hibernate
* H2 database
* Lombok
* GSON

## Installation

Install project:
```sh
mvn clean
mvn install
```
To start this project:
```sh
mvn spring-boot:run
```

Thanks to that it will be available at =  localhost: 8080


If port 8080 is not available, you can change the address in the file:
```sh
/src/main/resources/application.properties
```

## Docker

Build docker image
```sh
docker build -t empik_special_api:latest .
```

Start docker container
```sh
docker run -d --name empik_special_api_app --publish 8080:8080 empik_special_api
```