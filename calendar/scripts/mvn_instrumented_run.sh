#!/bin/sh

./mvnw clean package
java -javaagent:../dd-java-agent.jar -Ddd.trace.sample.rate=1 -Ddd.service=calendar -Ddd.env=dev -Ddd.version=0.0.1 -jar target/calendar-0.0.1-SNAPSHOT.jar
