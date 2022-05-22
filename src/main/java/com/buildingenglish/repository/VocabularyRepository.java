package com.buildingenglish.repository;

import com.buildingenglish.entity.VocabularyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocabularyRepository extends JpaRepository<VocabularyEntity, String> {
}
