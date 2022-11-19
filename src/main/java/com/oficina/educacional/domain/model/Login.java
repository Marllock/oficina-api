package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "login")
public class Login {

    @Id
    @Column(name = "login_id")
    private long loginId;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "login_email")
    @NotNull
    @Email
    private String loginEmail;

    @Column(name = "login_password")
    @NotNull
    private String loginPassword;
}
