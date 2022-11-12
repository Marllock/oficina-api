package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    long classId;

    @Column(name = "class_is_active")
    private boolean classIsActive;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    private Professor classProfessor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course classCourse;

    @OneToMany(mappedBy = "classModel")
    private Set<Grade> classGrades = new HashSet<>();
}
