/*
Unless explicitly stated otherwise all files in this repository are licensed
under the Apache 2.0 License.

This product includes software developed at Datadog (https://www.datadoghq.com/)
Copyright 2023 Datadog, Inc.
 */
package com.datadog.example.calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalendarApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalendarApplication.class, args);
    }
}
