#!/bin/sh

./mvnw clean package
java -jar target/calendar-0.0.1-SNAPSHOT.jar
