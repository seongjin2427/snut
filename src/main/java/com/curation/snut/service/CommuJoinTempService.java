package com.curation.snut.service;

import java.util.Map;

import com.curation.snut.dto.CommuJoinDTO;

public interface CommuJoinTempService {

    void joinApply(Map body);

    void joinAcceptAfterProcess(CommuJoinDTO commuJoinDTO);

}
