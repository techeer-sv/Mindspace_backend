FROM openjdk:11-jdk

COPY build/libs/*.jar app.jar

CMD ["java","-jar","/app.jar"]