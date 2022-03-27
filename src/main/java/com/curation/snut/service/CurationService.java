package com.curation.snut.service;

import java.util.List;

import com.curation.snut.dto.CurationDTO;
import com.curation.snut.entity.Curation;
import com.curation.snut.entity.Member;

import org.springframework.stereotype.Service;

@Service

public interface CurationService {
    public List<CurationDTO> cuList();

    void write(CurationDTO curationDTO);

    void delete(Long id);

    default Curation dtoToEntity(CurationDTO dto) {
        Member member = Member.builder()
                .email(dto.getWriter().getEmail())
                .build();

        Curation curation = Curation.builder()
                .curationNo(dto.getCurationNo())
                .curationText(dto.getCurationText())
                .curationTitle(dto.getCurationTitle())
                .open(dto.isOpen())
                .writer(member)
                .build();

        return curation;
    }

    default CurationDTO entityToDTO(Curation curation) {
        CurationDTO curationDTO = CurationDTO.builder()
                .curationNo(curation.getCurationNo())
                .curationText(curation.getCurationText())
                .curationTitle(curation.getCurationTitle())
                .writer(curation.getWriter())
                .regDate(curation.getRegDate())
                .modDate(curation.getModDate())
                .build();
        return curationDTO;
    }

}

// 롱인지 스트링인지
