FROM openjdk:8

WORKDIR /root

COPY ./demo-0.0.1-SNAPSHOT.jar .

CMD java -jar -Dspring.profiles.active=${active} demo-0.0.1-SNAPSHOT.jar