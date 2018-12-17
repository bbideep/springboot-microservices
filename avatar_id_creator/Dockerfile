FROM openjdk:8-jdk-alpine

EXPOSE 8080

ARG JAR_FILE=build/libs/AvatarCreator-0.1.0.jar

ADD ${JAR_FILE} AvatarCreator.jar

ENTRYPOINT ["java", "-jar", "AvatarCreator.jar"]
