package com.curation.snut.repository;

import javax.transaction.Transactional;

import com.curation.snut.entity.Note;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("select n from Note n order by noteNo")
    Page<Note> noteList(Pageable pageable, Long noteNo);

    @Modifying
    @Transactional
    @Query("delete from Note n where n.noteNo = :id")
    void deleteNote(Long id);

    Object getNoteByNoteNo(@Param("noteNo") Long noteNo);
}
