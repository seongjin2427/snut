package com.curation.snut.service;

import com.curation.snut.dto.CollectionDTO;
import com.curation.snut.entity.Collection;
import com.curation.snut.entity.SnutMember;

import java.util.List;

public interface CollectionService {

    List<CollectionDTO> getListOfSnutMember(String email);

    List<CollectionDTO> getListContainsSearchWord(String title);

    default Collection dtoToEntity(CollectionDTO collectionDTO) {

        Collection collection = Collection.builder()
                .colId(collectionDTO.getColId())
                .title(collectionDTO.getTitle())
                .open(collectionDTO.getOpen())
                .snutMember(SnutMember.builder().email(collectionDTO.getEmail()).build())
                .build();
        return collection;
    }

    default CollectionDTO entitiesToDTO(Collection collection) {
        CollectionDTO collectionDTO = CollectionDTO.builder()
                .colId(collection.getColId())
                .title(collection.getTitle())
                .open(collection.getOpen())
                .email(collection.getSnutMember().getEmail())
                .regDate(collection.getRegDate())
                .modDate(collection.getModDate())
                .build();
        return collectionDTO;
    }
}
