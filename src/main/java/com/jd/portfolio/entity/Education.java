package com.jd.portfolio.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "education")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String institution;

    private String degree;

    private String fieldOfStudy;

    private Double cgpa;

    private Integer startYear;

    private Integer endYear;

    @Column(length = 3000)
    private String description;
}