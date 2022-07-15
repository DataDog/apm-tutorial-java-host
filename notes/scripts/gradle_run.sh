#!/bin/sh

./gradlew clean distTar
# Copy the distribution to a new directory
mkdir -p to_run
cp build/distributions/notes-0.0.1-SNAPSHOT.tar to_run
cd to_run
tar -xf notes-0.0.1-SNAPSHOT.tar
cd ..
./to_run/notes-0.0.1-SNAPSHOT/bin/notes
