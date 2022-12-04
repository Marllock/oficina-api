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

    @Schema(implementation = User.class)
    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Schema(implementation = Course.class)
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course studentCourse;

    @Schema(implementation = Grade.class)
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private Set<Grade> studentGrades = new HashSet<>();
}
