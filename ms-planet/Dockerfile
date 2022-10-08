FROM openjdk:17-alpine
LABEL maintainer="Lenilson Teixeira <lenilsonts@gmail.com>"

WORKDIR /app

ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} application.jar

EXPOSE 8080

CMD ["sh", "-c", "java -jar application.jar"]