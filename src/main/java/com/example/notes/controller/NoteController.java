package com.example.notes.controller;

import com.example.notes.entity.Note;
import com.example.notes.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public ResponseEntity<Page<Note>> getAllNotes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String direction
    ){
        return ResponseEntity.ok(
                noteService.getAllNotes(page, size, sortBy, direction)
        );
    }

    @PostMapping("/notes")
    public void createNote(@Valid @RequestBody Note note){
        noteService.createNote(note);
    }

    @GetMapping("/notes/{id}")
    public Note getNotesById(@PathVariable Long id){
        return noteService.getNotesById(id);
    }

    @PutMapping("/notes/{id}")
    public void updateNotes(@PathVariable Long id, @Valid @RequestBody Note request){
        noteService.updateNotes(id, request);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteNode(id);
    }

    @GetMapping("/search")
    public List<Note> searchNotes(@RequestParam String keyword){
        return noteService.searchNotes(keyword);
    }

    @GetMapping("/archived")
    public ResponseEntity<Page<Note>> archiveNote(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String direction
    ){
        return ResponseEntity.ok(
                noteService.getArchivedNotes(page, size, sortBy, direction)
        );
    }

    @GetMapping("/active")
    public ResponseEntity<Page<Note>> activeNote(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String direction
    ){
        return ResponseEntity.ok(
                noteService.getActiveNotes(page, size, sortBy, direction)
        );
    }

    @PutMapping("/{id}/pin")
    public ResponseEntity<Note> pinNote(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(
                noteService.pinNote(id)
        );
    }

    @PutMapping("/{id}/unpin")
    public ResponseEntity<Note> unPinNote(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(
                noteService.unPinNote(id)
        );
    }

    @PutMapping("/{id}/archive")
    public ResponseEntity<Note> archiveNote(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(
                noteService.archiveNote(id)
        );
    }

    @PutMapping("/{id}/unarchive")
    public ResponseEntity<Note> unarchiveNote(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(
                noteService.unarchiveNote(id)
        );
    }
}
