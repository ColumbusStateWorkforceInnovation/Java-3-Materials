FROM openjdk:11.0.13-jre-slim

WORKDIR /app

ADD "app/build/libs/app.jar" "app.jar"

CMD ["java", "-cp", "app.jar", "edu.cscc.App"]