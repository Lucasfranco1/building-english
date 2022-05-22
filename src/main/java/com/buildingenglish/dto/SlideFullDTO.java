package com.buildingenglish.dto;

import com.buildingenglish.entity.CardEntity;
import lombok.Data;

@Data
public class SlideFullDTO {
    private String id;
    private String imageUrl;
    private String text;
    private Integer order;
    private CardEntity cardEntity;
}
