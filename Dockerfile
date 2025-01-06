FROM openjdk:17

EXPOSE 8080

Add target/spring-cache-image-actions-cicd.jar spring-cache-image-actions-cicd.jar

ENTRYPOINT["java","-jar","/spring-cache-image-actions-cicd.jar"]