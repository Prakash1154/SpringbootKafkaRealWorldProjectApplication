package com.kafka.realworldproject.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class WikiMediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String wikimediaData;

}
