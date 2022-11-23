package com.oficina.educacional.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Table(name = "student")
@Entity
public class Student {

    @Schema(
        description = "Students unique identifier",
        example = "123",
        required = true
    )
    @Id
    @NotNull
    @Column(name = "student_id")
    private long studentId;

    @Schema(
        description = "Relation between user and student",
        required = true
    )
    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Schema(
        description = "Relation between student and course",
        required = true
    )
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course studentCourse;

    @Schema(
        description = "List of students grade ",
        required = true
    )
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private Set<Grade> studentGrades = new HashSet<>();
}
