FROM openjdk:17
EXPOSE 8080
ADD target/docker-demo.jar docker-demo.jar 
#ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","docker-demo.jar"]