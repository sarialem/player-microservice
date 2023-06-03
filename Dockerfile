FROM gradle:7.6.1-jdk19-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon --stacktrace

FROM openjdk:19-jdk-alpine
WORKDIR service
COPY --from=build /build/libs/player-microservice*.jar ./

ENTRYPOINT ["java","-jar","player-microservice-1.0.0.jar"]