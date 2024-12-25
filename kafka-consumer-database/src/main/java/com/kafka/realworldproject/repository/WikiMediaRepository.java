package com.kafka.realworldproject.repository;

import com.kafka.realworldproject.entity.WikiMediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiMediaRepository extends JpaRepository<WikiMediaEntity,Long> {
}
