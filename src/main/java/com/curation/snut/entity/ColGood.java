package com.curation.snut.entity;

import javax.persistence.OneToOne;

public class ColGood{
    @OneToOne
    private Member email;
    @OneToOne
    private Collection ColNo;
}
