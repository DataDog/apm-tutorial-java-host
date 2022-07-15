package com.datadog.example.calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "calendar")
@Path("/calendar")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalendarController {
    private final Logger log = LoggerFactory.getLogger(CalendarController.class);

    @GET
    public String getDate(@Context HttpHeaders headers) throws IOException {
        // dump the headers
        var m = headers.getRequestHeaders();
        m.forEach((k, v) -> {
            System.out.format("%s: %s\n", k, Arrays.toString(v.toArray()));
        });
        // get back a random date in the year 2022
        int val = new Random().nextInt(365);
        LocalDate start = LocalDate.of(2022, Month.JANUARY, 1).plusDays(val);
        String output = start.format(DateTimeFormatter.ISO_LOCAL_DATE);
        log.info("generated date: " + output);
        // the correct JSON output should put this in quotes. Spring does not, so let's put quotes here by hand.
        return String.format("\"%s\"", output);
    }
}