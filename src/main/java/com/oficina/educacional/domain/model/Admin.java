package com.oficina.educacional.domain.model;

import javax.persistence.*;

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
