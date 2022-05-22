package com.buildingenglish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlideDTO {
    private String image;
    private String text;
    private Integer order;
}
