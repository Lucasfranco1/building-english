package com.buildingenglish.controller;

import com.buildingenglish.dto.CardDTO;
import com.buildingenglish.dto.VocabularyDTO;
import com.buildingenglish.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vocabulary")
public class VocabularyController {

    @Autowired
    private VocabularyService vocabularyService;

    @PostMapping("/save")
    public ResponseEntity<VocabularyDTO> saveVocabulary(@Validated @RequestBody VocabularyDTO vocabularyDTO){
        VocabularyDTO dto= vocabularyService.saveVocabulary(vocabularyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VocabularyDTO>>getAllVocabulary(){
        List<VocabularyDTO> vocabularyDTOList= vocabularyService.getAllVocabulary();
        return ResponseEntity.ok().body(vocabularyDTOList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VocabularyDTO> deleteVocabulary(@PathVariable String id){
        vocabularyService.deleteVocabulary(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<VocabularyDTO> modificationVocabulary(@PathVariable String id, @Validated @RequestBody VocabularyDTO vocabularyDTO){
        return ResponseEntity.ok(vocabularyService.updateVocabulary(id, vocabularyDTO));
    }
}
