package com.curation.snut.service;

import com.curation.snut.dto.SnutCollectionDTO;
import com.curation.snut.dto.CurationDTO;
import com.curation.snut.entity.Hashtag;
import com.curation.snut.entity.SnutCollection;
import com.curation.snut.entity.Curation;
import com.curation.snut.entity.Member;
import com.curation.snut.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public interface SnutCollectionService {

    // 성진
    List<SnutCollectionDTO> getCollectionsByWord(String word);

    Long snutCollectionRegister(SnutCollectionDTO snutCollectionDTO);

    default SnutCollectionDTO colToColDTO(SnutCollection collection) {

        SnutCollectionDTO dto = SnutCollectionDTO.builder()
                .collectionNo(collection.getCollectionNo())
                .collectionTitle(collection.getCollectionTitle())
                .collectionText(collection.getCollectionText())
                .email(collection.getWriter().getEmail())
                .hashtag(collection.getHashtag())
                .nickname(collection.getWriter().getNickName())
                .build();

        return dto;
    }

    default SnutCollection colDTOToCol(SnutCollectionDTO collectionDTO) {

        System.out.println("collectionDTO Service >>>> " + collectionDTO);
        Set<Hashtag> hashtag = (Set<Hashtag>) collectionDTO.getHashtag().stream().map(tag -> {
           return Hashtag.builder().tag(tag.toString()).build();
        }).collect(Collectors.toSet());

        System.out.println("collectionDTO Service after make hashtag >>>> " + collectionDTO);
        SnutCollection collection = SnutCollection.builder()
                .collectionNo(collectionDTO.getCollectionNo())
                .collectionTitle(collectionDTO.getCollectionTitle())
                .collectionText(collectionDTO.getCollectionText())
                .hashtag(hashtag)
                .writer(Member.builder().email(collectionDTO.getEmail()).build())
                .build();

        return collection;
    }

    /////////////////////////////////////////////////////////////////////////////////
}
