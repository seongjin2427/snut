package com.curation.snut.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "writer")
public class Note extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noteNo;

    private String noteTitle;
    private String noteText;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;
    @ManyToOne(fetch = FetchType.LAZY)
    private Sticker sticker;

    public void changeNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public void changeNoteText(String noteText) {
        this.noteText = noteText;
    }
    // sticker stciker 어떻게 처리해야
    // public void changeSticker(Long stickerNo) {
    // this.stickerNo = stickerNo;
    // }

    // public void changeSticker(String sticker) {
    // this.sticker = sticker;
    // }
}
