package com.curation.snut.service;

import java.util.List;

import com.curation.snut.dto.CommuJoinDTO;
import com.curation.snut.entity.CommuJoin;

public interface CommuJoinService {
    void joinAccept(CommuJoinDTO commuJoinDTO);

    void joinDelete(CommuJoinDTO commuJoinDTO);

    List<CommuJoin> findJoinCommu(String email);

    List<CommuJoin> joinList(String email);
}
