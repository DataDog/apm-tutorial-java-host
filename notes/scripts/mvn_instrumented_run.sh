#!/bin/sh

./mvnw clean package
java -javaagent:../dd-java-agent.jar -Ddd.trace.sample.rate=1 -Ddd.service=notes -Ddd.env=dev -Ddd.version=0.0.1 -jar target/notes-0.0.1-SNAPSHOT.jar
