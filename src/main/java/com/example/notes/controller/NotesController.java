package com.example.notes.controller;

import com.example.notes.entity.Notes;
import com.example.notes.service.NotesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NotesController {

    private final NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/notes")
    public List<Notes> getAllNotes(){
        return notesService.getAllNotes();
    }

    @PostMapping("/notes")
    public void createNote(@RequestBody Notes note){
        notesService.createNote(note);
    }

    @GetMapping("/notes/{id}")
    public Notes getNotesById(@PathVariable Long id){
        return notesService.getNotesById(id);
    }

    @PutMapping("/notes/{id}")
    public void updateNotes(@PathVariable Long id, @RequestBody Notes request){
        notesService.updateNotes(id, request);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable Long id){
        notesService.deleteNode(id);
    }
}
