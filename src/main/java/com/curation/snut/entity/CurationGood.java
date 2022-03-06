package com.curation.snut.entity;

import javax.persistence.OneToOne;

public class CurationGood{
    @OneToOne
    private Member email;
    @OneToOne
    private Curation cno;
}
