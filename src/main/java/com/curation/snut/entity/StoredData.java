package com.curation.snut.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StoredData extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Curation curation;
}
