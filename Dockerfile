FROM openjdk:8-jdk-alpine
EXPOSE 8089
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} tpachato.jar
ENTRYPOINT ["java","-jar","/tpachato.jar"]
