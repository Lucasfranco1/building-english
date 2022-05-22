package com.buildingenglish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {

    @NotNull(message = "Not null")
    @NotEmpty(message = "Not empty")
    @Size(min = 2, message = "The word cannot be so short")
    private String sentenceEnglish;

    @NotNull(message = "Not null")
    @NotEmpty(message = "Not empty")
    @Size(min = 2, message = "The word cannot be so short")
    private String sentenceSpanish;

    @NotNull(message = "Not null")
    @NotEmpty(message = "Not empty")
    @Size(min = 2, message = "The word cannot be so short")
    private String sentencePronunciation;
}
