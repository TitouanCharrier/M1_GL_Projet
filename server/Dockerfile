FROM docker.io/library/eclipse-temurin:21-jdk-jammy 

ENV APP_JAR_NAME server-0.0.1-SNAPSHOT.jar

WORKDIR /usr/app

EXPOSE 8080

COPY ./target/${APP_JAR_NAME} /usr/app/${APP_JAR_NAME}
COPY ./Database.db /usr/app/Database.db

ENTRYPOINT ["java", "-jar", "/usr/app/server-0.0.1-SNAPSHOT.jar"]
