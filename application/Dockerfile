FROM maven:3.6-jdk-8 AS build
COPY application/src /home/app/src
COPY application/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:8-jdk-alpine
COPY --from=build /home/app/target/cashback-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=test", "-jar", "/usr/local/lib/app.jar"]