package com.curation.snut.service;

import java.util.List;

import com.curation.snut.dto.NoteDTO;
import com.curation.snut.entity.Member;
import com.curation.snut.entity.Note;
import com.curation.snut.entity.Sticker;

import org.springframework.stereotype.Service;

@Service
public interface NoteService {
    public List<NoteDTO> NoteList();

    NoteDTO getNote(Long noteNo);

    void noteWrite(NoteDTO noteDTO);

    void noteModify(NoteDTO noteDTO);

    void noteDelete(Long id);

    default Note dtoToEntity(NoteDTO dto) {
        Member member = Member.builder()
                .email(dto.getEmail())
                .build();

        Sticker sticker = Sticker.builder()
                .stickerNo(dto.getStickerNo())
                .build();

        Note note = Note.builder()
                .noteNo(dto.getNoteNo())
                .noteText(dto.getNoteText())
                .noteTitle(dto.getNoteTitle())
                .writer(member)
                .sticker(sticker)
                // sticker추가
                .build();
        return note;
    }

    default NoteDTO entityToDTO(Note note) {
        NoteDTO noteDTO = NoteDTO.builder()
                .noteNo(note.getNoteNo())
                .noteText(note.getNoteText())
                .noteTitle(note.getNoteTitle())
                .email(note.getWriter().getEmail())
                .regDate(note.getRegDate())
                .modDate(note.getModDate())
                .build();

        return noteDTO;
    }
}
