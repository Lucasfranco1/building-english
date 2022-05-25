package com.buildingenglish.service;

import com.buildingenglish.dto.CardDTO;
import com.buildingenglish.dto.CardFullDTO;
import com.buildingenglish.entity.CardEntity;

import java.util.List;

public interface CardService {

    List<CardDTO> getAllCards();

    List<CardFullDTO> getFullCardsList();

    CardDTO save(CardDTO cardDTO);

    CardEntity getCardById(String id);

    CardDTO update(String id, CardDTO cardDTO);

    void delete(String id);

    CardDTO getCardDTOById(String id);

    /*
       Method random() = bring random phrases
     */
    List<CardDTO> random();

}
