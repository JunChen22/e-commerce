FROM adoptopenjdk:16_36-jre-hotspot
EXPOSE 8081
ADD ./target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
