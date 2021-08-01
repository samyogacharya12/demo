FROM maven:3.6.3-jdk-11-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B -f pom.xml clean package -DskipTests

FROM openjdk:11
MAINTAINER samyog
ADD target/demo-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-jar","/demo.jar"]
