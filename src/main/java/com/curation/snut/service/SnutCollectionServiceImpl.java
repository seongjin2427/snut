package com.curation.snut.service;

import com.curation.snut.dto.SnutCollectionDTO;
import com.curation.snut.entity.ColCuration;
import com.curation.snut.entity.Curation;
import com.curation.snut.entity.Member;
import com.curation.snut.entity.SnutCollection;
import com.curation.snut.repository.ColCurationRepository;
import com.curation.snut.repository.CurationRepository;
import com.curation.snut.repository.SnutCollectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SnutCollectionServiceImpl implements SnutCollectionService {

    private final SnutCollectionRepository snutCollectionRepository;
    private final ColCurationRepository colCurationRepository;
    private final CurationRepository curationRepository;

    @Override
    public List<SnutCollectionDTO> getCollectionsByWord(String word) {
        List collections = snutCollectionRepository.findCurationByWord(word);
        return (List) collections.stream().map(i -> colToColDTO((SnutCollection) i)).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Long snutCollectionRegister(SnutCollectionDTO snutCollectionDTO) {

        SnutCollection snutCollection = colDTOToCol(snutCollectionDTO);

        snutCollectionRepository.save(snutCollection);

        snutCollectionDTO.getCurations().stream().forEach(cu -> {
            Optional<Curation> curation = curationRepository.findById(cu.getCurationNo());
           ColCuration colCuration = ColCuration.builder()
                   .snutCollection(snutCollection)
                   .curation(curation.get())
                   .build();

           colCurationRepository.save(colCuration);
        });

        return snutCollection.getCollectionNo();
    }
}
