FROM openjdk:8-jre-slim
VOLUME /tmp
COPY order-starter/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]