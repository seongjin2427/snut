package com.curation.snut.service;

import com.curation.snut.dto.SnutCollectionDTO;
import com.curation.snut.entity.SnutCollection;
import com.curation.snut.repository.SnutCollectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SnutCollectionServiceImpl implements SnutCollectionService {

    @Autowired
    private final SnutCollectionRepository snutCollectionRepository;

    @Override
    public List<SnutCollectionDTO> getCollectionsByWord(String word) {
        List collections = snutCollectionRepository.findCurationByWord(word);
        return (List) collections.stream().map(i -> colToColDTO((SnutCollection) i)).collect(Collectors.toList());
    }
}
