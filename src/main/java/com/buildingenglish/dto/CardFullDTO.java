package com.buildingenglish.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CardFullDTO {
    private String id;
    private String sentenceEnglish;
    private String sentencePronunciation;
    private String sentenceSpanish;
    private LocalDateTime timestamps;
    private Boolean softDelete;
}
