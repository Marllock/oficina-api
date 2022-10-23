package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @OneToMany
    private List<Discipline> studentDisciplines;

    @ManyToOne
    @JoinColumn(name = "studentCourse")
    private Course studentCourse;
}
