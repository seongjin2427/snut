package com.curation.snut.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CollectionDTO {
    private Long colId;
    private String title;
    private Boolean open;

    private String email;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
