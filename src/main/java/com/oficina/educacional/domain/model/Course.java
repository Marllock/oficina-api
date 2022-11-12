package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false, unique = true)
    private Long courseId;

    @NotBlank
    @Length(max = 25)
    @Column(name = "course_name")
    private String courseName;

    @NotBlank
    @Length(max = 25)
    @Column(name = "course_name_normalized")
    private String courseNormalizedName;

    @NotBlank
    @Pattern(regexp = "[A-Z]{2}\\d{2}[A-Z]")
    @Column(name = "course_code", unique = true)
    private String courseCode;

    @CreationTimestamp
    @Column(name = "course_created_at")
    private LocalDateTime courseCreatedAt;

    @UpdateTimestamp
    @Column(name = "course_updated_at")
    private LocalDateTime courseUpdatedAt;

    @NotNull
    @Column(name = "course_is_active")
    private boolean courseIsActive;
}