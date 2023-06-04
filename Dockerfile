FROM gradle:7.6-jdk19-alpine AS wrapper
WORKDIR /service
COPY gradlew gradle settings.gradle ./
RUN gradle wrapper --no-daemon

FROM wrapper AS dependencies
WORKDIR /service
COPY build.gradle ./
RUN gradle dependencies --no-daemon

FROM dependencies AS build
WORKDIR /service
COPY src ./src
RUN gradle build -x test --no-daemon

FROM openjdk:19-jdk-alpine
WORKDIR /service
COPY --from=build /service/build/libs/player-microservice*.jar ./player-microservice.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","player-microservice.jar"]