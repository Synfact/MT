package com.example.MT.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Data
public class Income {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String source;
    private Date date;
}
