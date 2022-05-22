package com.buildingenglish.service;

import com.buildingenglish.dto.VocabularyDTO;
import com.buildingenglish.entity.VocabularyEntity;
import com.buildingenglish.exceptions.MyException;
import com.buildingenglish.mapper.VocabularyMapper;

import com.buildingenglish.repository.VocabularyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VocabularyServiceImpl implements VocabularyService{

    @Autowired
    private VocabularyRepository vocabularyRepository;

    @Autowired
    private VocabularyMapper vocabularyMapper;


    @Override
    public List<VocabularyDTO> getAllVocabulary() {
        List<VocabularyEntity> entities= vocabularyRepository.findAll();
        return vocabularyMapper.vocabularyEntityList2DTOList(entities);
    }

    @Override
    public VocabularyDTO saveVocabulary(VocabularyDTO vocabularyDTO) {
        VocabularyEntity vocabularyEntity= vocabularyMapper.vocabularyDTO2Entity(vocabularyDTO);
        VocabularyEntity vocabularySaved= vocabularyRepository.save(vocabularyEntity);
        return vocabularyMapper.vocabularyEntity2DTO(vocabularySaved);
    }

    @Override
    public VocabularyEntity getVocabularyById(String id) {
        Optional<VocabularyEntity> vocabularyEntity= vocabularyRepository.findById(id);
        if(!vocabularyEntity.isPresent()){
            throw new MyException("Vocabulary does not exits.");
        }
        return vocabularyEntity.get();
    }

    @Override
    public VocabularyDTO updateVocabulary(String id, VocabularyDTO vocabularyDTO) {
        Optional<VocabularyEntity> vocabularyEntity = vocabularyRepository.findById(id);
        if (vocabularyEntity.isPresent()) {
            VocabularyEntity vocabulary = vocabularyEntity.get();
            vocabulary.setEnglish(vocabularyDTO.getEnglish());
            vocabulary.setPronunciation(vocabularyDTO.getPronunciation());
            vocabulary.setDescription(vocabularyDTO.getDescription());
            vocabulary.setSpanish(vocabularyDTO.getSpanish());

            vocabularyRepository.save(vocabulary);
            return vocabularyMapper.vocabularyEntity2DTO(vocabulary);
        } else {
            throw new MyException("The vocabulary is not found in the database.");
        }
    }

    @Override
    public void deleteVocabulary(String id) {
        vocabularyRepository.deleteById(id);
    }

    @Override
    public VocabularyDTO getVocabularyDTOById(String id) {
        VocabularyEntity vocabularyEntity= this.getVocabularyById(id);
        return vocabularyMapper.vocabularyEntity2DTO(vocabularyEntity);
    }
}
