package com.example.notes.repository;

import com.example.notes.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {
    List<Notes> findByTitleContainingIgnoreCase(String keyword);
    List<Notes> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(
            String message,
            String message2
    );

}
