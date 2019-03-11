#!/usr/bin/env bash
mvn clean install
rm -rf *.zip
zip -r eureka-service.zip ./*
