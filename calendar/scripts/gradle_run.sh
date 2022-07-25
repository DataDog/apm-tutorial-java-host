#!/bin/sh

./gradlew shadowJar
java -jar build/libs/calendar-0.0.1-SNAPSHOT-all.jar