FROM openjdk:18.0.2

EXPOSE 8081

ADD ./build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]