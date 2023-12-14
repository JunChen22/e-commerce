FROM adoptopenjdk:16_36-jre-hotspot
EXPOSE 8082
ADD ./target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
