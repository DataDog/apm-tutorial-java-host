/*
Unless explicitly stated otherwise all files in this repository are licensed
under the Apache 2.0 License.

This product includes software developed at Datadog (https://www.datadoghq.com/)
Copyright 2023 Datadog, Inc.
 */
package com.datadog.example.notes;

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


public class NotesHelper {

    private static final Logger Log = LoggerFactory.getLogger(NotesHelper.class);

    //Manual trace annotation
    //@Trace(operationName = "traceMethod1", resourceName = "NotesHelper.doLongRunningProcess")
    public void doLongRunningProcess() throws InterruptedException {
        Thread.sleep(300);
        Log.info("Hello from the long running process");
        privateMethod1();
    }

    //Manual trace annotation
    //@Trace(operationName = "traceMethod2", resourceName = "NotesHelper.anotherProcess")
    public void anotherProcess() throws InterruptedException {
        Thread.sleep(50);
        Log.info("Hello from the anotherProcess");
    }

    private void privateMethod1() throws InterruptedException {

        //Manual span example
        /* 
        Tracer tracer = GlobalTracer.get();
        // Tags can be set when creating the span
        Span span = tracer.buildSpan("manualSpan1")
            .withTag(DDTags.SERVICE_NAME, "NotesHelper")
            .withTag(DDTags.RESOURCE_NAME, "privateMethod1")
            .start();
        try (Scope scope = tracer.activateSpan(span)) {
            // Tags can also be set after creation 
            span.setTag("postCreationTag", 1);
            */
            Thread.sleep(30);
            Log.info("Hello from the custom privateMethod1");
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
