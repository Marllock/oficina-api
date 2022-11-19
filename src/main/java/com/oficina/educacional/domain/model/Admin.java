package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "admin_id")
    private long adminId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
