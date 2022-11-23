package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {

    @Schema(
        description = "Course unique identifier",
        example = "123",
        required = true
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false, unique = true)
    private Long courseId;

    @Schema(
        description = "Course name",
        example = "Ensino Médio",
        required = true
    )
    @NotBlank
    @Length(max = 25)
    @Column(name = "course_name")
    private String courseName;

    @Schema(
        description = "Course normalized name",
        example = "Ensino Médio",
        required = true
    )
    @NotBlank
    @Length(max = 25)
    @Column(name = "course_name_normalized")
    private String courseNormalizedName;

    @Schema(
        description = "Course code",
        example = "AS31A",
        required = true
    )
    @NotBlank
    @Pattern(regexp = "[A-Z]{2}\\d{2}[A-Z]")
    @Column(name = "course_code", unique = true)
    private String courseCode;

    @Schema(
        description = "Date of creation of course",
        example = "03/03/2012",
        required = true
    )
    @CreationTimestamp
    @Column(name = "course_created_at")
    private LocalDateTime courseCreatedAt;

    @Schema(
        description = "Date of last update on Course",
        example = "05/06/2022",
        required = true
    )
    @UpdateTimestamp
    @Column(name = "course_updated_at")
    private LocalDateTime courseUpdatedAt;

    @Schema(
        description = "Course Status",
        example = "active",
        required = true
    )
    @NotNull
    @Column(name = "course_is_active")
    private boolean courseIsActive;
}