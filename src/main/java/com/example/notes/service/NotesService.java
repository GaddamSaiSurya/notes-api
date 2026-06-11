package com.example.notes.service;

import com.example.notes.entity.Notes;
import com.example.notes.exception.IdNotFoundException;
import com.example.notes.repository.NotesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    private final NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public List<Notes> getAllNotes(){
        return notesRepository.findAll();
    }

    public void createNote(Notes note){
        notesRepository.save(note);
    }

    public Notes getNotesById(Long id){
        return notesRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));
    }

    public void updateNotes(Long id, Notes request){

        Notes existingNote = getNotesById(id);
        existingNote.setTitle(request.getTitle());
        existingNote.setContent(request.getContent());
        notesRepository.save(existingNote);

    }

    public void deleteNode(Long id){

        Notes exisingNode = getNotesById(id);
        notesRepository.delete(exisingNode);

    }
}
