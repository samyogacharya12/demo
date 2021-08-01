FROM maven:3.6.3-jdk-11-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B -f pom.xml clean package -DskipTests

FROM openjdk:11
MAINTAINER samyog
COPY --from=build /workspace/target/*.jar demo.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/demo.jar"]
