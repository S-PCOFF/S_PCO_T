FROM openjdk:8

WORKDIR /root

COPY ./home/ec2-user/app/step4/0.0.1-SNAPSHOT.jar .

CMD java -jar -Dspring.profiles.active=${active} 0.0.1-SNAPSHOT.jar