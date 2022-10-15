package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "discipline")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discipline_id", nullable = false)
    private Long disciplineId;

    @NotBlank
    @Column(name = "discipline_code", unique = true)
    private String disciplineCode;

    @NotBlank
    @Length(max = 25)
    @Column(name = "discipline_name")
    private String disciplineName;

    @NotBlank
    @Length(max = 25)
    @Column(name = "discipline_normalized_name")
    private String disciplineNormalizedName;

    @CreationTimestamp
    @Column(name = "discipline_created_at")
    private LocalDateTime disciplineCreatedAt;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course courseId;
}