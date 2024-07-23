package com.michaelryan.carryon.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * This class defines the attributes for Airport Entities (POJOs) which
 * representing table data that can be persisted in the database
 */
@Entity
@Table(name="airports")
@Data
public class Airports {
    /**
     * Each attribute represents a column in the table
     */
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
