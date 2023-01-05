FROM maven:3.8.6-jdk-8

WORKDIR /app
COPY . .
RUN mvn clean install
EXPOSE 12003
CMD mvn spring-boot:run