/*
Unless explicitly stated otherwise all files in this repository are licensed
under the Apache 2.0 License.

This product includes software developed at Datadog (https://www.datadoghq.com/)
Copyright 2023 Datadog, Inc.
 */
package com.datadog.example.notes;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/notes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NoteController {

    @Inject
    private NotesLogic notesLogic = new NotesLogic();

    @GET
    public List<Note> index() throws InterruptedException {
        return notesLogic.getAll();
    }

    @GET
    @Path("/{id}")
    public Note getNoteId(@PathParam("id") Long id) {
        return notesLogic.getNoteById(id);
    }

    @POST
    public Note createNote(@QueryParam("desc") String desc, @QueryParam("add_date") String addDate) throws IOException, InterruptedException {
        return notesLogic.createNote(desc, addDate);
    }

    @PUT
    @Path("/{id}")
    public Note updateNote(@PathParam("id") Long id, @QueryParam("desc") String desc) {
        return notesLogic.updateNote(id, desc);
    }

    @DELETE
    @Path("/{id}")
    public String deleteNote(@PathParam("id") Long id) {
        return notesLogic.deleteNote(id);
    }
}