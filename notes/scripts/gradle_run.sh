#!/bin/sh

./gradlew shadowJar
java -jar build/libs/notes-0.0.1-SNAPSHOT-all.jar