package com.michaelryan.carryon.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="airports")
@Data
public class Airports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String state;

    @Column
    private String code;

    @Column
    private String city;

    @Column
    private String name;
}
