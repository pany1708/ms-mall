FROM open-jdk:8
MAINTAINER pany<yong.pan@daocloud.com>

ADD ./target/microservice-gateway-zuul-0.0.1-SNAPSHOT.jar /app/microservice-gateway-zuul.jar
CMD ["java", "-Xmx200m", "-jar", "/app/microservice-gateway-zuul.jar"]

EXPOSE 8050