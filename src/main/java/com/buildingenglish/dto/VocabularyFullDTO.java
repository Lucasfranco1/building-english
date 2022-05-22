package com.buildingenglish.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VocabularyFullDTO {
    private String id;
    private String wordEnglish;
    private String workPronunciation;
    private String wordSpanish;
    private String description;
    private LocalDateTime timestamps;
    private Boolean softDelete;

}
