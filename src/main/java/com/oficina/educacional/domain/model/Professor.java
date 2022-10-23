package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "professor")
public class Professor {

    @Id
    private long professorId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "professor_course_id", nullable = false)
    private Course professorCourse;
}
