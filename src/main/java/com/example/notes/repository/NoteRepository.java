package com.example.notes.repository;

import com.example.notes.entity.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByTitleContainingIgnoreCase(String keyword);
    List<Note> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(
            String message,
            String message2
    );
    Page<Note> findByArchivedTrue(Pageable pageable);
    Page<Note> findByArchivedFalse(Pageable pageable);


}
