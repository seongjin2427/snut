package com.curation.snut.service;

import java.util.List;
import java.util.Map;

import com.curation.snut.dto.CommuJoinDTO;
import com.curation.snut.entity.CommuJoinTemp;

public interface CommuJoinTempService {

    String joinApply(CommuJoinDTO commuJoinDTO);

    void joinAcceptAfterProcess(CommuJoinDTO commuJoinDTO);

    List<CommuJoinTemp> joinAlertList(String memberEmail);

}
