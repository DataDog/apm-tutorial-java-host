#!/bin/sh

./gradlew clean distTar
# Copy the distribution to a new directory
mkdir -p to_run
cp build/distributions/calendar-0.0.1-SNAPSHOT.tar to_run
cd to_run
tar -xf calendar-0.0.1-SNAPSHOT.tar
cd ..
env JAVA_OPTS='-javaagent:../dd-java-agent.jar -XX:FlightRecorderOptions=stackdepth=256 -Ddd.trace.sample.rate=1 -Ddd.service=calendar -Ddd.env=staging -Ddd.version=0.0.1' ./to_run/calendar-0.0.1-SNAPSHOT/bin/calendar
