package com.curation.snut.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import com.curation.snut.dto.CurationDTO;
import com.curation.snut.entity.Curation;
import com.curation.snut.repository.CurationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        return null;// null이면 안됨. 마저완성할것
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    }

    @Override
    public void read(CurationDTO curationDTO) {

    }

}
