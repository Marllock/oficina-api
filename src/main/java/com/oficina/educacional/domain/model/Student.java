package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Table(name = "student")
@Entity
public class Student {

    @Id
    @NotNull
    private long studentId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course studentCourse;

    @OneToMany(mappedBy = "student")
    private Set<Grades> studentGrades = new HashSet<>();
}
