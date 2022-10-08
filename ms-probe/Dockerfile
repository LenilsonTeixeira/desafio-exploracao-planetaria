# CONFIGURAÇÃO COM MULTI STAGE BUILD
# FROM maven:3.8.3-openjdk-17 AS build
# LABEL maintainer="Lenilson Teixeira <lenilsonts@gmail.com>"
#
# WORKDIR /build
#
# COPY pom.xml /build
# COPY src /build/src
# RUN mvn package -DskipTests
#
# FROM openjdk:17-alpine
# WORKDIR /app
# RUN addgroup app && adduser -S -G app app
# USER app
# COPY --from=build /build/target/*.jar /app/application.jar
#
# EXPOSE 8084
#
# CMD ["sh", "-c", "java -jar application.jar"]

# CONFIGURAÇÃO MAIS SIMPLES PARA GERAR A IMAGEM LOCAL DE FORMA MAIS RÁPIDA SEM PRECISAR BAIXAR TODA VEZ QUE RODAR AS DEPENDÊNCIAS
FROM openjdk:17-alpine
LABEL maintainer="Lenilson Teixeira <lenilsonts@gmail.com>"

WORKDIR /app

ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} application.jar

EXPOSE 8084

CMD ["sh", "-c", "java -jar application.jar"]