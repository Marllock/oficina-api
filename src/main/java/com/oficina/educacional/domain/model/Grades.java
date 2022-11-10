package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "grades")
public class Grades {

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

    @Column(name = "grade_code")
    private UUID gradeCode = UUID.randomUUID();

    @Column(name = "grade_score")
    private double gradeScore;
}
