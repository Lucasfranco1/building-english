package com.buildingenglish.controller;

import com.buildingenglish.dto.CardDTO;
import com.buildingenglish.dto.CardFullDTO;
import com.buildingenglish.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/save")
    public ResponseEntity<CardDTO> saveCard(@Validated @RequestBody CardDTO cardDTO){
        CardDTO savedCard= cardService.save(cardDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCard);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CardDTO>> getAllCards(){
        List<CardDTO>cardDTOList= cardService.getAllCards();
        return ResponseEntity.ok().body(cardDTOList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CardDTO> deleteCard(@PathVariable String id){
        cardService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardDTO> modificationCards(@PathVariable String id, @Validated @RequestBody CardDTO cardDTO){
       return ResponseEntity.ok(cardService.update(id, cardDTO));
    }
}


