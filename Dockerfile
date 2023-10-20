FROM openjdk:17

EXPOSE 8080

WORKDIR /app

ADD target/lab0-project-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]