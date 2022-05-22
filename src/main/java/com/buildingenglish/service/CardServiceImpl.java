package com.buildingenglish.service;

import com.buildingenglish.dto.CardDTO;
import com.buildingenglish.dto.CardFullDTO;
import com.buildingenglish.entity.CardEntity;
import com.buildingenglish.exceptions.MyException;
import com.buildingenglish.mapper.CardMapper;
import com.buildingenglish.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class CardServiceImpl implements  CardService{

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardMapper cardMapper;


    @Override
    public List<CardDTO> getAllCards() {
        List<CardEntity> entities= cardRepository.findAll();
        return cardMapper.cardEntityList2DTOList(entities);
    }

    @Override
    public List<CardFullDTO> getFullCardsList() {
        List<CardEntity> entities= cardRepository.findAll();
        return cardMapper.cardEntityList2DTOFullList(entities);
    }

    @Override
    public CardDTO save(CardDTO cardDTO) {
        CardEntity cardEntity= cardMapper.cardDTO2Entity(cardDTO);
        CardEntity cardSaved= cardRepository.save(cardEntity);
        return cardMapper.cardEntity2DTO(cardSaved);
    }

    @Override
    public CardEntity getCardById(String id)  {
        Optional<CardEntity> cardEntity= cardRepository.findById(id);
        if(!cardEntity.isPresent()){
            throw new MyException("Card does not exits.");
        }
        return cardEntity.get();
    }

    @Override
    public CardDTO update(String id, CardDTO cardDTO) {
        Optional<CardEntity> cardEntity = cardRepository.findById(id);
        if (cardEntity.isPresent()) {
            CardEntity card = cardEntity.get();
            card.setSentenceEnglish(cardDTO.getSentenceEnglish());
            card.setSentenceSpanish(cardDTO.getSentenceSpanish());
            card.setSentencePronunciation(cardDTO.getSentencePronunciation());
            cardRepository.save(card);
            return cardMapper.cardEntity2DTO(card);
        } else {
            throw new MyException("The card is not found in the database.");
        }
    }

    @Override
    public void delete(String id) {
        cardRepository.deleteById(id);
    }

    @Override
    public CardDTO getCardDTOById(String id) {
        CardEntity cardEntity= this.getCardById(id);
        return cardMapper.cardEntity2DTO(cardEntity);
    }
}
