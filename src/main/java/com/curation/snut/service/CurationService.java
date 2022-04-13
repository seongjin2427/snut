package com.curation.snut.service;

import java.util.List;
import java.util.Map;

import com.curation.snut.dto.CurationDTO;
import com.curation.snut.dto.SnutCollectionDTO;
import com.curation.snut.entity.Curation;
import com.curation.snut.entity.Member;

import org.springframework.stereotype.Service;

@Service

public interface CurationService {

    // 성진
    List<CurationDTO> getCurationsByCollectionNo(Long colId);

    List<CurationDTO> getCurationsByWord(String word);

    ///////////////////////////////////////////////////////////////////////////

    public List<CurationDTO> CuList();

    public List<CurationDTO> searchCurationTitle(String searchCurationTitle);

    CurationDTO getCuration(Long curationNo);

    void write(CurationDTO curationDTO);

//    void modify(CurationDTO curationDTO);

    void delete(Long id);

    default Curation dtoToEntity(CurationDTO dto) {

        Curation curation = Curation.builder()
                .curationNo(dto.getCurationNo())
                .curationText(dto.getCurationText())
                .curationTitle(dto.getCurationTitle())
                .hashtag(dto.getHashtag())
                .open(dto.isOpen())
                .writer(Member.builder().email(dto.getEmail()).build())
                .build();

        return curation;
    }

    default CurationDTO entityToDTO(Curation curation) {
        CurationDTO curationDTO = CurationDTO.builder()
                .curationNo(curation.getCurationNo())
                .curationText(curation.getCurationText())
                .curationTitle(curation.getCurationTitle())
                .email(curation.getWriter().getEmail())
                .hashtag(curation.getHashtag())
                .nickname(curation.getWriter().getNickName())
                .regDate(curation.getRegDate())
                .modDate(curation.getModDate())
                .build();
        return curationDTO;
    }
}