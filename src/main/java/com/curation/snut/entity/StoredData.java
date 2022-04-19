package com.curation.snut.entity;

import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StoredData extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Member member;

    @Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    private SnutCollection snutCollection;

    @Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Curation curation;
}
