package com.curation.snut.service;

import java.util.List;

import com.curation.snut.dto.CommuJoinDTO;
import com.curation.snut.entity.CommuJoin;

public interface CommuJoinService {
    void joinAccept(CommuJoinDTO commuJoinDTO);

    public void joinDelete(CommuJoinDTO commuJoinDTO);

    public List<CommuJoin> joinList(Long no, String email);
}
