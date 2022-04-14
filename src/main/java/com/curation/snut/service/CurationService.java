package com.curation.snut.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.curation.snut.dto.CurationDTO;
import com.curation.snut.dto.CurationImageDTO;
import com.curation.snut.dto.SnutCollectionDTO;
import com.curation.snut.entity.Curation;
import com.curation.snut.entity.CurationImage;
import com.curation.snut.entity.Member;

import org.springframework.stereotype.Service;

@Service

public interface CurationService {

    // 성진
    List<CurationDTO> getCurationsByCollectionNo(Long colId);

    List<CurationDTO> getCurationsByWord(String word);

    Long register(CurationDTO curationDTO);
    ///////////////////////////////////////////////////////////////////////////

    public List<CurationDTO> CuList();

    public List<CurationDTO> searchCurationTitle(String searchCurationTitle);

    CurationDTO getCuration(Long curationNo);

//    void write(CurationDTO curationDTO);

//    void modify(CurationDTO curationDTO);

    void delete(Long id);

    default Map<String, Object> dtoToEntity(CurationDTO dto) {

        Map<String, Object> entitMap = new HashMap<>();

        Curation curation = Curation.builder()
                .curationNo(dto.getCurationNo())
                .curationText(dto.getCurationText())
                .curationTitle(dto.getCurationTitle())
                .pickedColor(dto.getPickedColor())
                .pickedEmoji(dto.getPickedEmoji())
                .hashtag(dto.getHashtag())
                .open(dto.isOpen())
                .writer(Member.builder().email(dto.getEmail()).build())
                .build();

        entitMap.put("curation", curation);

        List<CurationImageDTO> imageDTOList = dto.getImageDTOList();

        if(imageDTOList != null && imageDTOList.size() > 0) {
            List<CurationImage> curationImageList = imageDTOList.stream()
                    .map(curationImageDTO -> {

                        CurationImage curationImage = CurationImage.builder()
                                .path(curationImageDTO.getPath())
                                .imageName(curationImageDTO.getImgName())
                                .uuid(curationImageDTO.getUuid())
                                .curation(curation)
                                .build();
                        return curationImage;
                    }).collect(Collectors.toList());
            entitMap.put("imgList", curationImageList);
        }

        return entitMap;
    }

    default CurationDTO entityToDTO(Curation curation) {
        CurationDTO curationDTO = CurationDTO.builder()
                .curationNo(curation.getCurationNo())
                .curationText(curation.getCurationText())
                .curationTitle(curation.getCurationTitle())
                .email(curation.getWriter().getEmail())
                .pickedColor(curation.getPickedColor())
                .pickedEmoji(curation.getPickedEmoji())
                .hashtag(curation.getHashtag())
                .nickname(curation.getWriter().getNickName())
                .regDate(curation.getRegDate())
                .modDate(curation.getModDate())
                .build();
        return curationDTO;
    }
}