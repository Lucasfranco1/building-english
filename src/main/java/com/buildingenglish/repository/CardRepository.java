package com.buildingenglish.repository;

import com.buildingenglish.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, String> {
    /**
     * Query query to shuffle phrases
     * @return LIMIT 2 card
     */
    @Query(value = "SELECT * from card order by RAND() LIMIT 2", nativeQuery = true)
    public List<CardEntity> rand();
}
