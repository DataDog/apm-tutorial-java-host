#!/bin/sh

./gradlew shadowJar
env JAVA_OPTS='-javaagent:../dd-java-agent.jar -XX:FlightRecorderOptions=stackdepth=256 -Ddd.trace.sample.rate=1 -Ddd.service=notes -Ddd.env=staging -Ddd.version=0.0.1' build/libs/notes-0.0.1-SNAPSHOT-all.jar

