


FROM openjdk:17-jdk

WORKDIR /app

COPY target/mychat.jar /app/mychat.jar

EXPOSE 8088

CMD ["java", "-jar", "mychat.jar"]