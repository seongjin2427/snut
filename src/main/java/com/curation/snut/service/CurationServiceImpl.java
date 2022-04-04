package com.curation.snut.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.curation.snut.dto.CurationDTO;
import com.curation.snut.entity.Curation;
import com.curation.snut.repository.CurationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class CurationServiceImpl implements CurationService {
    @Autowired
    private final CurationRepository curationRepository;

    @Override
    public List<CurationDTO> CuList() {
        List<Curation> cuList = curationRepository.findAll();
        log.info(cuList);
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
    public void modify(CurationDTO dto) {
        Optional<Curation> result = curationRepository.findById(dto.getCurationNo());
        if (result.isPresent()) {
            Curation curation = result.get();
            curation.changeCurationTitle(dto.getCurationTitle());
            curation.changeCurationText(dto.getCurationText());
            curationRepository.save(curation);
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        curationRepository.deleteById(id);
    }

    @Override
    public CurationDTO getCuration(Long curationNo) {
        Curation curation = curationRepository.findById(curationNo).orElseThrow();

        CurationDTO curationDTO = entityToDTO(curation);
        // CurationDTO.setNickName(nickname);

        return curationDTO;

    }

    @Override
    public List<CurationDTO> searchCurationTitle(String searchCurationTitle) {
        List<Object[]> curationList = curationRepository.findByCurationTitleContaining(searchCurationTitle);
        List<CurationDTO> curationDTOList = curationList.stream()
                .map(entity -> entityToDTO((Curation) entity[0], (Long) entity[1])).collect(Collectors.toList());
        return curationDTOList;
    }

}
