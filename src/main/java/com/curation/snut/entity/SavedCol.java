package com.curation.snut.entity;

import javax.persistence.OneToOne;

public class SavedCol {
    @OneToOne
    private Member email;
    @OneToOne
    private Collection colNo ;
}
