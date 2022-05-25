package com.buildingenglish.repository;

import com.buildingenglish.entity.VocabularyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VocabularyRepository extends JpaRepository<VocabularyEntity, String> {
    /**
     * Query to shuffle word
     * @return LIMIT 2 card
     */
    @Query(value = "SELECT * from vocabulary order by RAND() LIMIT 1", nativeQuery = true)
    public List<VocabularyEntity> rand();
}
