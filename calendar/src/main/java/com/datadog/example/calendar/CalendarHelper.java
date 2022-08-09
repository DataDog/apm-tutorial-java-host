package com.datadog.example.calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Manual tracing import libraries

/*import datadog.trace.api.Trace;
import datadog.trace.api.DDTags;

import io.opentracing.Scope;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.tag.Tags;

import io.opentracing.util.GlobalTracer;

import java.io.PrintWriter;
import java.io.StringWriter;*/


public class CalendarHelper {

    Logger Log = LoggerFactory.getLogger(CalendarHelper.class);

    //Manual trace annotation
    //@Trace(operationName = "calTraceMethod1", resourceName = "CalendarHelper.doLongRunningProcess")
    public void calDoLongRunningProcess() throws InterruptedException {
        Thread.sleep(300);
        Log.info("Hello from the long running process in Calendar");
        calPrivateMethod1();
    }

    //Manual trace annotation
    //@Trace(operationName = "calTraceMethod2", resourceName = "CalendarHelper.anotherProcess")
    public void calAnotherProcess() throws InterruptedException {
        Thread.sleep(50);
        Log.info("Hello from the anotherProcess in Calendar");
    }

    private void calPrivateMethod1() throws InterruptedException {

        //Manual span example
        /* 
        Tracer tracer = GlobalTracer.get();
        // Tags can be set when creating the span
        Span span = tracer.buildSpan("calendarManualSpan1")
            .withTag(DDTags.SERVICE_NAME, "CalendarHelper")
            .withTag(DDTags.RESOURCE_NAME, "calPrivateMethod1")
            .start();
        try (Scope scope = tracer.activateSpan(span)) {
            // Tags can also be set after creation 
            span.setTag("postCreationTag", 1);
            */
            Thread.sleep(30);
            Log.info("Hello from the custom privateMethod1 in Calendar");
            /* 
        } catch (Exception e) {
            // Set error on span
            span.setTag(Tags.ERROR, true);
            span.setTag(DDTags.ERROR_MSG, e.getMessage());
            span.setTag(DDTags.ERROR_TYPE, e.getClass().getName());
            
            final StringWriter errorString = new StringWriter();
            e.printStackTrace(new PrintWriter(errorString));
            span.setTag(DDTags.ERROR_STACK, errorString.toString());

            Log.info(errorString.toString());
        } finally {
            span.finish();
        }*/


    }
}
