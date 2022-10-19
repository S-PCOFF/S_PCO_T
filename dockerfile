FROM openjdk:8

WORKDIR /root

COPY ./home/ec2-user/app/step3/S_PCO_T-*.jar .

CMD java -jar -Dspring.profiles.active=${active} S_PCO_T-*.jar