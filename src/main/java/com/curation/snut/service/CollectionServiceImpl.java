package com.curation.snut.service;

import com.curation.snut.dto.CollectionDTO;
import com.curation.snut.entity.Collection;
import com.curation.snut.entity.SnutMember;
import com.curation.snut.repository.CollectionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class CollectionServiceImpl implements CollectionService{

    private final CollectionRepository collectionRepository;

    @Override
    public List<CollectionDTO> getListOfSnutMember(String email) {

        log.info("getListOfSnutMember.........................." + email);
        SnutMember snutMember = SnutMember.builder().email(email).build();

        List<Collection> result = collectionRepository.findBySnutMember(snutMember);

        log.info("snutMember.getModDate : " + snutMember.getModDate());

        return result.stream().map(
                collection -> entitiesToDTO(collection)).collect(Collectors.toList());
    }

    @Override
    public List<CollectionDTO> getListContainsSearchWord(String title) {

        log.info("getListContainsSearchWord................." + title);
        List<Collection> result = collectionRepository.findByTitleContains(title);

        log.info("result.get(0).getModDate() : " + result.get(0).getModDate());
        return result.stream().map(
                collection -> entitiesToDTO(collection)).collect(Collectors.toList());
    }


}
