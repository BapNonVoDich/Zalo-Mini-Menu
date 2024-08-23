FROM maven:3.8.3-openjdk-21 AS build
COPY . .
RUN mvn clean install

#
# Package stage
#
FROM eclipse-temurin:17-jdk
COPY --from=build /target/spring-boot-boilerplate.jar demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]