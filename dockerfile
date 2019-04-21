FROM openjdk:8-jdk-alpine
COPY ./build/libs/patientservice-0.0.1.jar patientservice.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/patientservice.jar"]