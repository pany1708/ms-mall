FROM open-jdk:8
MAINTAINER pany<yong.pan@daocloud.com>

ADD ./target/microservice-eureka-server-0.0.1-SNAPSHOT.jar /app/microservice-eureka-service.jar
CMD ["java", "-Xmx200m", "-jar", "/app/microservice-eureka-service.jar"]

EXPOSE 8761