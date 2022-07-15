package com.datadog.example.notes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
public class NotesLogic {
    @Inject
    @PersistenceContext
    private EntityManager em;

    private final NotesHelper nh = new NotesHelper();
    private final HttpClient httpClient = HttpClient.newHttpClient();

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
        Note note = new Note();
        if (addDate != null && addDate.equalsIgnoreCase("y")) {
            HttpRequest cReq = HttpRequest.newBuilder().uri(URI.create("http://localhost:9090/calendar")).GET().build();
            HttpResponse<String> cResp = httpClient.send(cReq, HttpResponse.BodyHandlers.ofString());
            ObjectMapper obj = new ObjectMapper();
            String date = obj.readValue(cResp.body(), String.class);
            desc = desc + " with date " + date;
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
