package com.oficina.educacional.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id", nullable = false)
    private Long cursoId;

    @NotBlank
    @Length(max = 25)
    @Column(name = "curso_name")
    private String name;

    @NotBlank
    @Length(max = 25)
    @Column(name = "curso_name_normalized")
    private String normalizedName;

    @CreationTimestamp
    @Column(name = "curso_created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "curso_updated_at")
    private LocalDateTime updatedAt;
}