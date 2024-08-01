FROM openjdk:11-jdk-slim
COPY target/desafio-itau.jar /app/desafio-itau.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "desafio-itau.jar"]