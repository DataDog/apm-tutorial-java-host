/*
Unless explicitly stated otherwise all files in this repository are licensed
under the Apache 2.0 License.

This product includes software developed at Datadog (https://www.datadoghq.com/)
Copyright 2023 Datadog, Inc.
 */
package com.datadog.example.notes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.util.List;

@Component
public class NotesLogic {
    @Inject
    @PersistenceContext
    private EntityManager em;

    private final NotesHelper nh = new NotesHelper();
    private final OkHttpClient httpClient = new OkHttpClient();

    @Value("${CALENDAR_HOST:localhost}")
    private String host;

    public NotesLogic(){
    }

    public List<Note> getAll() throws InterruptedException {
        List<Note> allNotes = em.createQuery("from Note", Note.class).getResultList();
        nh.doLongRunningProcess();
        nh.anotherProcess();
        return allNotes;
    }

    public Note getNoteById(Long id) {
        Note note = em.find(Note.class, id);
        return note;
    }

    @Transactional
    public Note createNote(String desc, String addDate) throws IOException, InterruptedException {
        //Switch URL for calendar app based on location of program execution

        Note note = new Note();
        if (addDate != null && addDate.equalsIgnoreCase("y")) {
            Request cReq = new Request.Builder().url("http://" + host + ":9090/calendar").build();
            try (Response cResp = httpClient.newCall(cReq).execute()) {
                ObjectMapper obj = new ObjectMapper();
                String date = obj.readValue(cResp.body().string(), String.class);
                desc = desc + " with date " + date;
            }
        }
        note.setDescription(desc);
        em.persist(note);
        return note;
    }

    @Transactional
    public Note updateNote(Long id, String desc) {
        Note note = em.find(Note.class, id);
        note.setDescription(desc);
        em.persist(note);
        return note;
    }

    @Transactional
    public String deleteNote(Long id) {
        Note note = em.find(Note.class, id);
        em.remove(note);
        return "Deleted";
    }
}
