FROM eclipse-temurin:21-jre
EXPOSE 8080
ARG JAR_FILE=target/gitg-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
