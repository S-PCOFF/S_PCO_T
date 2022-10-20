FROM openjdk:8

WORKDIR /root

COPY ./home/ec2-user/app/step4/S_PCO_T-0.0.1-SNAPSHOT.jar .

CMD java -jar -Dspring.profiles.active=${active} S_PCO_T-0.0.1-SNAPSHOT.jar