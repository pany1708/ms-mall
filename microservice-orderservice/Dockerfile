FROM open-jdk:8
MAINTAINER pany<yong.pan@daocloud.com>

ADD ./target/microservice-orderservice-0.0.1-SNAPSHOT.jar /app/microservice-orderservice.jar
CMD ["java", "-Xmx200m", "-jar", "/app/microservice-orderservice.jar"]

EXPOSE 7900