package com.oficina.educacional.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "course_id", nullable = false)
    private Course professorCourse;

    @JsonIgnore
    @OneToMany(mappedBy = "classProfessor")
    private List<Class> professorClasses = new ArrayList<>();
}
