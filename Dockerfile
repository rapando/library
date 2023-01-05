FROM openjdk:19-jdk-alpine

RUN apk add --no-cache maven

WORKDIR /app
COPY . .
RUN mv src/main/resources/prod.application.properties src/main/resources/application.properties
RUN mvn clean install
EXPOSE 12003
CMD mvn spring-boot:run