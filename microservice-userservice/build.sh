#!/usr/bin/env bash
scp  target/microservice-userservice-0.0.1-SNAPSHOT.jar root@192.168.0.99:~/userservice/
scp  Dockerfile root@192.168.0.99:~/userservice/
echo "copy down..."
ssh root@192.168.0.99 && mvn package -f ~/userservice/pom.xml && docker build -t order-service:latest ~/userservice/


