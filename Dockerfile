FROM openjdk:17-alpine

WORKDIR /app

ADD target/lab0-project-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]