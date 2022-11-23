package com.oficina.educacional.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(
        description = "professor unique identifier",
        example = "123",
        required = true
    )
    @Id
    private long professorId;

    @Schema(
        description = "Relation between professor and user",
        example = "123",
        required = true
    )
    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Schema(
        description = "Relation between professor and course",
        example = "123",
        required = true
    )
    @NotNull
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course professorCourse;

    @Schema(
        description = "List of classes that the professor have",
        example = "123",
        required = true
    )
    @JsonIgnore
    @OneToMany(mappedBy = "classProfessor")
    private List<Class> professorClasses = new ArrayList<>();
}
