package com.run.gtask.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estimated_times")
public class EstimatedTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description; // Descrierea opțiunii, ex: "1 oră", "2 ore", "Half day", etc.

    @Column(name = "hours", nullable = false)
    private int hours; // Timpul estimat în ore
}
