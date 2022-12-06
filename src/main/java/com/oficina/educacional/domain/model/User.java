package com.oficina.educacional.domain.model;

import com.oficina.educacional.domain.model.enums.ProfileTypeEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Schema(
        description = "User unique identifier",
        example = "123",
        required = true
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private long userId;

    @Schema(
        description = "User name",
        example = "Ricardo",
        required = true
    )
    @Column(name = "user_name")
    @NotNull
    private String userName;

    @Schema(
        description = "User normalized name",
        example = "ricardo_dos_santos",
        required = true
    )
    @Column(name = "user_normalized_name")
    @NotNull
    private String userNormalizedName;

    @Schema(
        description = "User e-mail",
        example = "ricardo@gmail.com",
        required = true
    )
    @Column(name = "user_email", unique = true)
    @NotNull
    @Email
    private String userEmail;

    @Schema(
        description = "User document number",
        example = "117.700.707-77",
        required = true
    )
    @Column(name = "user_document", unique = true)
    @NotNull
    private String userDocument;

    @Schema(
        description = "User birth date",
        example = "02/03/2000",
        required = true
    )
    @Column(name = "user_birth_date")
    @NotNull
    private LocalDate userBirthDate;

    @Schema(
        description = "User telephone",
        example = "(22)922354865",
        required = true
    )
    @NotNull
    @Column(name = "user_telephone")
    private String userTelephone;

    @Schema(
        description = "User street address",
        example = "Rua Joaquim Dias Castanho",
        required = true
    )
    @Column(name = "user_street")
    @NotNull
    private String userStreet;

    @Schema(
        description = "User street number",
        example = "123",
        required = true
    )
    @Column(name = "user_street_number")
    @NotNull
    @Length(max = 10)
    private String userStreetNumber;

    @Schema(
        description = "User complements address",
        example = "Ao lado da UTFPR",
        required = true
    )
    @Column(name = "user_complement")
    private String userComplement;

    @Schema(
        description = "User district",
        example = "Centro",
        required = true
    )
    @Column(name = "user_district")
    @NotNull
    private String userDistrict;

    @Schema(
        description = "User zipcode",
        example = "86300-000",
        required = true
    )
    @Column(name = "user_zipcode")
    @NotNull
    private String userZipCode;

    @Schema(
        description = "User city",
        example = "Londrina",
        required = true
    )
    @Column(name = "user_city")
    @NotNull
    private String userCity;

    @Schema(
        description = "User state",
        example = "Paraná",
        required = true
    )
    @Column(name = "user_state")
    @NotNull
    private String userState;

    @Schema(
        description = "User profile level",
        example = "Admin",
        required = true
    )
    @Column(name = "user_profile")
    private long userProfile;

    @Schema(
        description = "User status",
        example = "active",
        required = true
    )
    @Column(name = "user_is_active")
    private boolean userIsActive;

    @Schema(
        description = "User date of creation",
        example = "02/04/2020",
        required = true
    )
    @CreationTimestamp
    @Column(name = "user_created_at")
    private LocalDateTime userCreatedAt;

    public ProfileTypeEnum getUserProfileType() {
        return ProfileTypeEnum.valueOf(userProfile);
    }

    public void setUserProfileType(ProfileTypeEnum profileType) {
        userProfile = profileType.getProfileTypeIdEnum();
    }
}
