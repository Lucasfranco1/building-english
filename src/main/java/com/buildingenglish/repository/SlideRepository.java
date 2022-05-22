package com.buildingenglish.repository;

import com.buildingenglish.entity.SlideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlideRepository extends JpaRepository<SlideEntity, String> {
}
