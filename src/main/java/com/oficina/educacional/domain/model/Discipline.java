package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "discipline")
public class Discipline {

    @Schema(
        description = "Discipline unique identifier",
        example = "123",
        required = true
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discipline_id", nullable = false)
    private Long disciplineId;

    @Schema(
        description = "Discipline code",
        example = "AS31A",
        required = true
    )
    @NotBlank
    @Column(name = "discipline_code", unique = true)
    private String disciplineCode;

    @Schema(
        description = "Discipline name",
        example = "Matemática",
        required = true
    )
    @NotBlank
    @Length(max = 25)
    @Column(name = "discipline_name")
    private String disciplineName;

    @Schema(
        description = "Discipline normalized name",
        example = "educacao_fisica",
        required = true
    )
    @NotBlank
    @Length(max = 25)
    @Column(name = "discipline_normalized_name")
    private String disciplineNormalizedName;

    @Schema(
        description = "Date of creation of discipline",
        example = "02/03/2013",
        required = true
    )
    @CreationTimestamp
    @Column(name = "discipline_created_at")
    private LocalDateTime disciplineCreatedAt;

    @Schema(
        description = "Course unique identifier",
        example = "123",
        required = true
    )
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course courseId;
}