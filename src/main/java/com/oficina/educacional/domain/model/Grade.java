package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import io.swagger.v3.oas.annotations.media.Schema;

@Setter
@Getter
@Entity
@Table(name = "grade")
public class Grade {

    @Schema(
        description = "Relation between student, grade and class ",
        required = true
    )
    @EmbeddedId
    private ClassStudentsKey gradeId;

    @Schema(
        description = "Student",
        required = true
    )
    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private Student student;

    @Schema(
        description = "Relation between class and grade",
        required = true
    )
    @ManyToOne
    @MapsId("class_id")
    @JoinColumn(name = "class_id")
    private Class classModel;

    @Schema(
        description = "Relation between grade and score and student",
        example = "123",
        required = true
    )
    @Column(name = "grade_score")
    private double gradeScore;
}
