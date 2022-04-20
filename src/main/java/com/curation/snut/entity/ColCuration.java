package com.curation.snut.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ColCuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coCuId;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "cu_col_id")
    private Curation curation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "col_cu_id")
    private SnutCollection snutCollection;
}
