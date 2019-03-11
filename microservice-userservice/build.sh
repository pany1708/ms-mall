#!/usr/bin/env bash
mvn clean install
VERSION=$(date +%Y%m%d%H%M%S)
rm -rf *.zip
zip -r user-service""$VERSION.zip ./*
