package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Embeddable
public class ClassStudentsKey implements Serializable {

    @Column(name = "grade_id")
    private long gradeId;

    @Column(name = "class_id")
    private long classId;

    @Column(name = "student_id")
    private long studentId;
}
