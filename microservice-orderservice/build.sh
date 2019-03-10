#!/usr/bin/env bash
scp target/microservice-orderservice-0.0.1-SNAPSHOT.jar root@192.168.0.99:~/orderservice/
scp Dockerfile root@192.168.0.99:~/orderservice/
ssh root@192.168.0.99
cd ~/orderservice/
mvn package
docker build -t order-service:latest .