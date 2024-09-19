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
    private String description;

    @Column(name = "hours", nullable = false)
    private int hours; // Timpul estimat în ore, ideal era sa fie minute, dar mi-am dat seama ulterior
}
