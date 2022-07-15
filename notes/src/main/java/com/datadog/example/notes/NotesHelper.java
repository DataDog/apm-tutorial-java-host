package com.datadog.example.notes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotesHelper {

    Logger Log = LoggerFactory.getLogger(NotesHelper.class);

    public void doLongRunningProcess() throws InterruptedException {
        Thread.sleep(300);
        Log.info("Hello from the long running process");
        privateMethod1();
    }

    public void anotherProcess() throws InterruptedException {
        Thread.sleep(50);
        Log.info("Hello from the anotherProcess");
    }

    private void privateMethod1() throws InterruptedException {
        Thread.sleep(30);
        Log.info("Hello from the custom privateMethod1");
    }
}
