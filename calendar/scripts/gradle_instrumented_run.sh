#!/bin/sh

./gradlew clean shadowJar
java -javaagent:../dd-java-agent.jar -XX:FlightRecorderOptions=stackdepth=256 -Ddd.trace.sample.rate=1 -Ddd.service=calendar -Ddd.env=dev -jar -Ddd.version=0.0.1 build/libs/calendar-0.0.1-SNAPSHOT-all.jar