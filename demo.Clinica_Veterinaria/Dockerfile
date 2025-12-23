FROM eclipse-temurin:21-jdk
ARG JAR_FILE=target/demo.Clinica_Veterinaria-0.0.1.jar
COPY ${JAR_FILE} app_veterinaria.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_veterinaria.jar"]
