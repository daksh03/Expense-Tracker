FROM openjdk:17

WORKDIR /app

COPY /target/expense-tracker-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 6798

ENTRYPOINT [ "java","-jar","app.jar" ]