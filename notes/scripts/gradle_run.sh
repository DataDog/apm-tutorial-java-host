#!/bin/sh

./gradlew clean shadowJar
java -jar build/libs/notes-0.0.1-SNAPSHOT-all.jar