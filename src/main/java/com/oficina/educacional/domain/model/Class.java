package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "class")
public class Class {

    @Schema(
        description = "Class unique identifier",
        example = "123",
        required = true
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    long classId;

    @Schema(
        description = "Class status",
        example = "active",
        required = true
    )
    @Column(name = "class_is_active")
    private boolean classIsActive;

    @Schema(
        description = "Relation between professor and class",
        required = true
    )
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    private Professor classProfessor;

    @Schema(
        description = "relation between class and course",
        required = true
    )
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course classCourse;

    @Schema(
        description = "Relation betweem class and grade",
        required = true
    )
    @OneToMany(mappedBy = "classModel")
    private Set<Grade> classGrades = new HashSet<>();
}
