package com.buildingenglish.mapper;

import com.buildingenglish.dto.CardDTO;
import com.buildingenglish.dto.CardFullDTO;
import com.buildingenglish.entity.CardEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CardMapper {

    public CardEntity cardDTO2Entity(CardDTO dto){
        CardEntity cardEntity=new CardEntity();

        cardEntity.setSentenceEnglish(dto.getSentenceEnglish());
        cardEntity.setSentenceSpanish(dto.getSentenceSpanish());
        cardEntity.setSentencePronunciation(dto.getSentencePronunciation());

        return cardEntity;
    }

    public CardDTO cardEntity2DTO(CardEntity entity){
        CardDTO cardDTO = new CardDTO();
        cardDTO.setSentenceEnglish(entity.getSentenceEnglish());
        cardDTO.setSentenceSpanish(entity.getSentenceSpanish());
        cardDTO.setSentencePronunciation(entity.getSentencePronunciation());

        return cardDTO;
    }
    public CardFullDTO cardEntity2DTOFull(CardEntity entity){
        CardFullDTO cardFullDTO= new CardFullDTO();

        cardFullDTO.setId(entity.getId());
        cardFullDTO.setSentenceEnglish(entity.getSentenceEnglish());
        cardFullDTO.setSentenceSpanish(entity.getSentenceSpanish());
        cardFullDTO.setSentencePronunciation(entity.getSentencePronunciation());

        LocalDateTime date = entity.getTimestamps();
        String formatDate = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        cardFullDTO.setTimestamps(LocalDateTime.parse(formatDate));

        return  cardFullDTO;
    }

    public List<CardFullDTO> cardEntityList2DTOFullList(List<CardEntity> entities){
        List<CardFullDTO> cardFullList= new ArrayList<>();

        for(CardEntity entity: entities){
            cardFullList.add(this.cardEntity2DTOFull(entity));
        }

        return cardFullList;
    }

    public List<CardEntity> cardDTOList2EntityList(List<CardDTO> cardDTOList){
        List<CardEntity> entityList= new ArrayList<>();

        for(CardDTO dto : cardDTOList){
            entityList.add(this.cardDTO2Entity(dto));
        }
        return entityList;
    }
    public List<CardDTO> cardEntityList2DTOList(List<CardEntity> entityList){
        List<CardDTO> cardDTOList= new ArrayList<>();

        for(CardEntity entity: entityList){
            cardDTOList.add(this.cardEntity2DTO(entity));
        }
        return cardDTOList;
    }


}
