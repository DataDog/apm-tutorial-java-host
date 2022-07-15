#!/bin/sh

./gradlew clean distTar
# Copy the distribution to a new directory
mkdir -p to_run
cp build/distributions/notes-0.0.1-SNAPSHOT.tar to_run
cd to_run
tar -xf notes-0.0.1-SNAPSHOT.tar
cd ..
./to_run/notes-0.0.1-SNAPSHOT/bin/notes
env JAVA_OPTS='-javaagent:../dd-java-agent.jar -XX:FlightRecorderOptions=stackdepth=256 -Ddd.trace.sample.rate=1 -Ddd.service=notes -Ddd.env=staging -Ddd.version=0.0.1' ./to_run/notes-0.0.1-SNAPSHOT/bin/notes
