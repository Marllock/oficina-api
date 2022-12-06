package com.oficina.educacional.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin {


    @Schema(
        description = "Admin unique identifier",
        example = "123",
        required = true
    )
    @Id
    @Column(name = "admin_id")
    private long adminId;

    @Schema(
        description = "Relation between admin and user",
        example = "123",
        required = true
    )
    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
