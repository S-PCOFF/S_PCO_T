FROM openjdk:8

WORKDIR /root

COPY ./S_PCO_T-0.0.1-SNAPSHOT.jar .

CMD java -jar -Dspring.profiles.active=${active} S_PCO_T-0.0.1-SNAPSHOT.jar