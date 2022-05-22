package com.buildingenglish.mapper;

import com.buildingenglish.dto.VocabularyDTO;
import com.buildingenglish.entity.VocabularyEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VocabularyMapper {

    public VocabularyEntity vocabularyDTO2Entity(VocabularyDTO dto){
        VocabularyEntity vocabularyEntity = new VocabularyEntity();

        vocabularyEntity.setEnglish(dto.getEnglish());
        vocabularyEntity.setPronunciation(dto.getPronunciation());
        vocabularyEntity.setSpanish(dto.getSpanish());
        vocabularyEntity.setDescription(dto.getDescription());

        return vocabularyEntity;
    }
    public VocabularyDTO vocabularyEntity2DTO(VocabularyEntity entity){
        VocabularyDTO vocabularyDTO= new VocabularyDTO();

        vocabularyDTO.setEnglish(entity.getEnglish());
        vocabularyDTO.setPronunciation(entity.getPronunciation());
        vocabularyDTO.setSpanish(entity.getSpanish());
        vocabularyDTO.setDescription(entity.getDescription());

        return vocabularyDTO;
    }
    public List<VocabularyEntity> vocabularyDTOList2EntityList(List<VocabularyDTO> dtoList){
        List<VocabularyEntity>entities= new ArrayList<>();

        for (VocabularyDTO dto : dtoList) {
            entities.add(this.vocabularyDTO2Entity(dto));
        }
        return entities;
    }
    public List<VocabularyDTO> vocabularyEntityList2DTOList(List<VocabularyEntity> entityList){
        List<VocabularyDTO> dtoList= new ArrayList<>();
        for (VocabularyEntity entity: entityList) {
            dtoList.add(this.vocabularyEntity2DTO(entity));
        }
        return dtoList;
    }
}
