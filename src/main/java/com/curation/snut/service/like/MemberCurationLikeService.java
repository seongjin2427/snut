package com.curation.snut.service.like;

public interface MemberCurationLikeService {

    public void likes(Long mcolId, String email);
    public void unlikes(Long mcolId, String email);
}
