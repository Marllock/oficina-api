package com.oficina.educacional.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ClassStudentsKey implements Serializable {

    @Schema(
        description = "Grade unique identifier",
        example = "123",
        required = true
    )
    @Column(name = "grade_id")
    private String gradeId = UUID.randomUUID().toString();

    @Schema(
        description = "Class unique identifier",
        example = "123",
        required = true
    )
    @Column(name = "class_id")
    private long classId;

    @Schema(
        description = "Students unique identifier",
        example = "123",
        required = true
    )
    @Column(name = "student_id")
    private long studentId;
}
