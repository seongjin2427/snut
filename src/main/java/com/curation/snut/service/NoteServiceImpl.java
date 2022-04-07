package com.curation.snut.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.curation.snut.dto.NoteDTO;
import com.curation.snut.entity.Note;
import com.curation.snut.repository.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    @Autowired
    private final NoteRepository noteRepository;

    @Override
    public List<NoteDTO> NoteList() {
        List<Note> noteList = noteRepository.findAll();
        log.info(noteList);
        List<NoteDTO> noteDTOList = noteList.stream()
                .map(note -> entityToDTO(note)).collect(Collectors.toList());
        return noteDTOList;
    }

    @Override
    public void noteWrite(NoteDTO noteDTO) {
        Note note = dtoToEntity(noteDTO);
        noteRepository.save(note);
    }

    @Override
    public void noteModify(NoteDTO noteDTO) {
        Optional<Note> result = noteRepository.findById(noteDTO.getNoteNo());
        if (result.isPresent()) {
            Note note = result.get();
            note.changeNoteTitle(noteDTO.getNoteTitle());
            note.changeNoteText(noteDTO.getNoteText());
            // entity note에서 수정할것.
            // note.changeSticker(dto.getStickerNo());
            // 스티커추가
            noteRepository.save(note);
        }
    }

    @Transactional
    @Override
    public void noteDelete(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public NoteDTO getNote(Long noteNo) {
        Note note = noteRepository.findById(noteNo).orElseThrow();

        NoteDTO noteDTO = entityToDTO(note);
        // CurationDTO.setNickName(nickname);

        return noteDTO;

    }

}
