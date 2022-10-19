package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "professor")
public class Professor extends User {

    @Id
    @Column(name = "professor_id")
    private long professorId;

    @MapsId
    @OneToOne(mappedBy = "professor")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "professor_course_id", nullable = false)
    private Course course;


}
