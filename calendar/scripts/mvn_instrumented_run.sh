#!/bin/sh

./mvnw clean package
java -javaagent:../dd-java-agent.jar -XX:FlightRecorderOptions=stackdepth=256 -Ddd.trace.sample.rate=1 -Ddd.service=calendar -Ddd.env=staging -Ddd.version=0.0.1 -jar target/calendar-0.0.1-SNAPSHOT.jar
