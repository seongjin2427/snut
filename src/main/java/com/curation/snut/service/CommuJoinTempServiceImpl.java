package com.curation.snut.service;

import java.util.Map;

import com.curation.snut.dto.CommuJoinDTO;
import com.curation.snut.entity.CommuJoinTemp;
import com.curation.snut.entity.Community;
import com.curation.snut.entity.Member;
import com.curation.snut.idclass.CommuJoinTempId;
import com.curation.snut.repository.CommuJoinTempRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommuJoinTempServiceImpl implements CommuJoinTempService {

        private final CommuJoinTempRepository commuJoinTempRepository;

        @Override
        public void joinApply(Map body) {
                Member member = Member.builder()
                                .email(body.get("email").toString())
                                .build();
                Community community = Community.builder()
                                .no(Long.valueOf(body.get("no").toString()))
                                .build();

                CommuJoinTemp commuJoinTemp = CommuJoinTemp.builder()
                                .tMember(member)
                                .tCommunity(community).build();
                commuJoinTempRepository.save(commuJoinTemp);
        }

        @Transactional
        @Override
        public void joinAcceptAfterProcess(CommuJoinDTO commuJoinDTO) {
                CommuJoinTempId id = CommuJoinTempId.builder().tMember(commuJoinDTO.getMember().getEmail())
                                .tCommunity(commuJoinDTO.getCommunity().getNo()).build();
                commuJoinTempRepository.deleteById(id);

        }

}
