#!/bin/sh

./mvnw clean package
java -jar target/notes-0.0.1-SNAPSHOT.jar
