FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/employee-api.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]