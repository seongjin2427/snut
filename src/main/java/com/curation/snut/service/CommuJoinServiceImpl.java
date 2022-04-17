package com.curation.snut.service;

import java.util.List;

import javax.transaction.Transactional;

import com.curation.snut.dto.CommuJoinDTO;
import com.curation.snut.entity.CommuJoin;
import com.curation.snut.entity.Community;
import com.curation.snut.entity.Member;
import com.curation.snut.idclass.CommuJoinId;
import com.curation.snut.repository.CommuJoinRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommuJoinServiceImpl implements CommuJoinService {
    private final CommuJoinRepository commuJoinRepository;

    @Override
    public void joinAccept(CommuJoinDTO commuJoinDTO) {

        CommuJoinId id = CommuJoinId.builder().jMember(commuJoinDTO.getMember().getEmail())
                .jCommunity(commuJoinDTO.getCommunity().getNo()).build();

        if (!(commuJoinRepository.findById(id).isPresent())) {
            Member member = Member.builder()
                    .email(commuJoinDTO.getMember().getEmail())
                    .build();
            Community community = Community.builder()
                    .no(commuJoinDTO.getCommunity().getNo())
                    .build();

            CommuJoin commuJoin = CommuJoin.builder().jMember(member).jCommunity(community).build();

            commuJoinRepository.save(commuJoin);
        }
    }

    @Override
    public List<CommuJoin> joinList(String email) {
        return commuJoinRepository.findMyCommu(email);
    }

    @Transactional
    @Override
    public void joinDelete(CommuJoinDTO commuJoinDTO) {
        CommuJoinId id = CommuJoinId.builder().jMember(commuJoinDTO.getMember().getEmail())
                .jCommunity(commuJoinDTO.getCommunity().getNo()).build();
        commuJoinRepository.deleteById(id);

    }

    @Override
    public List<CommuJoin> findJoinCommu(String email) {
        return commuJoinRepository.findJoinCommu(email);
    }

}
