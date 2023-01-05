FROM openjdk:19-jdk-alpine

RUN apk add --no-cache maven

WORKDIR /app
COPY . .
RUN mvn clean install
EXPOSE 12003
CMD mvn spring-boot:run