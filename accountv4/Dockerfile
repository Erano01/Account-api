FROM maven:3.8.6-jdk-11-alpine as builder

COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

RUN mvn -f /usr/src/app/pom.xml clean package



FROM openjdk:11
WORKDIR account
COPY target/*.jar account-api.jar
EXPOSE 8080:8080

ENTRYPOINT ["java", "-jar", "account-api.jar"]