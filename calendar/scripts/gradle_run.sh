#!/bin/sh

./gradlew clean distTar
# Copy the distribution to a new directory
mkdir -p to_run
cp build/distributions/calendar-0.0.1-SNAPSHOT.tar to_run
cd to_run
tar -xf calendar-0.0.1-SNAPSHOT.tar
cd ..
./to_run/calendar-0.0.1-SNAPSHOT/bin/calendar
