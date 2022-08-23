FROM khipu/openjdk17-alpine

ADD target/employee-api.jar app.jar


ENTRYPOINT ["java","-jar","app.jar"]"
