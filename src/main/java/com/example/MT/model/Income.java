package com.example.MT.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
public class Income {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long amount;
    private String source;
    private LocalDateTime date = LocalDateTime.now();
}
