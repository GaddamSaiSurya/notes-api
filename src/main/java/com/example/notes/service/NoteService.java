package com.example.notes.service;

import com.example.notes.entity.Note;
import com.example.notes.exception.IdNotFoundException;
import com.example.notes.repository.NoteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Page<Note> getAllNotes(int page, int size, String sortBy, String direction){

        Sort sort = Sort.by(
                Sort.Order.desc("pinned"),
                direction.equalsIgnoreCase("asc")
                        ? Sort.Order.asc(sortBy)
                        : Sort.Order.desc(sortBy)
        );

        Pageable pageable = PageRequest.of(page, size);
        return noteRepository.findAll(pageable);
    }

    public void createNote(Note note){
        noteRepository.save(note);
    }

    public Note getNotesById(Long id){
        return noteRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));
    }

    public void updateNotes(Long id, Note request){

        Note existingNote = getNotesById(id);
        existingNote.setTitle(request.getTitle());
        existingNote.setContent(request.getContent());
        noteRepository.save(existingNote);

    }

    public void deleteNode(Long id){

        Note exisingNode = getNotesById(id);
        noteRepository.delete(exisingNode);

    }

    public List<Note> searchNotes(String keyword){
        return noteRepository
                .findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(keyword, keyword);
    }

    public Note archiveNote(Long id){
        Note note = getNotesById(id);
        note.setArchived(true);
        return noteRepository.save(note);
    }

    public Note unarchiveNote(Long id){
        Note note = getNotesById(id);
        note.setArchived(false);
        return noteRepository.save(note);
    }

    public Note pinNote(Long id){
        Note note = getNotesById(id);
        note.setPinned(true);
        return noteRepository.save(note);
    }

    public Note unPinNote(Long id){
        Note note = getNotesById(id);
        note.setPinned(false);
        return noteRepository.save(note);
    }

    public Page<Note> getArchivedNotes(
            int page,
            int size,
            String sortBy,
            String direction
    ){
        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return noteRepository.findByArchivedTrue(pageable);
    }

    public Page<Note> getActiveNotes(
            int page,
            int size,
            String sortBy,
            String direction
    ){
        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return noteRepository.findByArchivedFalse(pageable);
    }


}
