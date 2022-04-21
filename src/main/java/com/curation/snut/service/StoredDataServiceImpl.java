package com.curation.snut.service;

import com.curation.snut.entity.Curation;
import com.curation.snut.entity.Member;
import com.curation.snut.entity.StoredData;
import com.curation.snut.repository.CurationRepository;
import com.curation.snut.repository.MemberRepository;
import com.curation.snut.repository.StoredDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class StoredDataServiceImpl implements StoredDataService{

    private final StoredDataRepository storedDataRepository;
    private final MemberRepository memberRepository;
    private final CurationRepository curationRepository;

    @Transactional
    @Override
    public void storeCuration(Long no, String email) {

        Optional<Curation> curation = curationRepository.findById(no);
        Optional<Member> member = memberRepository.findById(email);
        StoredData storedData = StoredData.builder().curation(curation.get()).member(member.get()).build();

        storedDataRepository.save(storedData);




    }
}
