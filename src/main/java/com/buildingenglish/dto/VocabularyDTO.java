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
public class VocabularyDTO {

    @NotEmpty
    @NotNull
    @Size(min = 2, message = "The word cannot be so short")
    private String english;

    @NotEmpty
    @Size(min = 2, message = "The word cannot be so short")
    private String pronunciation;

    @Size(min = 2, message = "The word cannot be so short")
    private String spanish;

    @Size(min = 2, message = "The word cannot be so short")
    private String description;
}
