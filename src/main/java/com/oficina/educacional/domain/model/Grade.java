package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "grade")
public class Grade {

    @EmbeddedId
    private ClassStudentsKey gradeId;

    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("class_id")
    @JoinColumn(name = "class_id")
    private Class classModel;

    @Column(name = "grade_score")
    private double gradeScore;
}
