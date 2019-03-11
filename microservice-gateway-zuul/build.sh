#!/usr/bin/env bash
mvn clean install
rm -rf *.zip
zip -r gateway-service.zip ./*
