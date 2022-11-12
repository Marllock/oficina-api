package com.oficina.educacional.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Table(name = "student")
@Entity
public class Student {

    @Id
    @NotNull
    @Column(name = "student_id")
    private long studentId;

    @Column(name = "student_code")
    @NotBlank
    private UUID studentCode;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course studentCourse;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private Set<Grade> studentGrades = new HashSet<>();
}
