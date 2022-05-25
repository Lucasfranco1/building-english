package com.buildingenglish.service;


import com.buildingenglish.dto.VocabularyDTO;
import com.buildingenglish.entity.VocabularyEntity;

import java.util.List;

public interface VocabularyService {

    List<VocabularyDTO> getAllVocabulary();


    VocabularyDTO saveVocabulary(VocabularyDTO vocabularyDTO);

    VocabularyEntity getVocabularyById(String id);

    VocabularyDTO updateVocabulary(String id, VocabularyDTO vocabularyDTO);

    void deleteVocabulary(String id);

    VocabularyDTO getVocabularyDTOById(String id);

    List<VocabularyDTO> random();
}
