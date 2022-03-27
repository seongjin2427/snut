package com.curation.snut.service;

import java.util.List;
import java.util.stream.Collectors;

import com.curation.snut.dto.CurationDTO;
import com.curation.snut.entity.Curation;
import com.curation.snut.repository.CurationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CurationServiceImpl implements CurationService {
    @Autowired
    private final CurationRepository curationRepository;

    @Override
    public List<CurationDTO> cuList() {
        List<Curation> cuList = curationRepository.findAll();
        List<CurationDTO> curationDTOList = cuList.stream()
                .map(curation -> entityToDTO(curation)).collect(Collectors.toList());
        return curationDTOList;
    }

    @Override
    public void write(CurationDTO curationDTO) {
        Curation curation = dtoToEntity(curationDTO);
        curationRepository.save(curation);
    }

    @Override
    public void delete(Long id) {
        Long CurationLists = curationRepository.searchCuration(id);
        if (CurationLists != null) {
            curationRepository.deleteById(id);
        }

    }
}
