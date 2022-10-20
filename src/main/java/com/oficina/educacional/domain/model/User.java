package com.oficina.educacional.domain.model;

import com.oficina.educacional.domain.model.enums.ProfileTypeEnum;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private long userId;

    @Column(name = "user_name")
    @NotNull
    private String userName;

    @Column(name = "user_normalized_name")
    @NotNull
    private String userNormalized_name;

    @Column(name = "user_email", unique = true)
    @NotNull
    @Email
    private String userEmail;

    @Column(name = "userCPF", unique = true)
    @NotNull
    private String userCPF;

    @Column(name = "user_birth_date")
    @NotNull
    private LocalDate userBirthDate;

    @Column(name = "user_gender_description")
    private String userGenderDescription;//enum

    @Column(name = "user_telephone")
    private String userTelephone;

    @Column(name = "user_street")
    @NotNull
    private String userStreet;

    @Column(name = "user_street_number")
    @NotNull
    @Length(max = 10)
    private String userStreetNumber;

    @Column(name = "user_complement")
    private String userComplement;

    @Column(name = "user_district")
    @NotNull
    private String userDistrict;

    @Column(name = "user_zipcode")
    @NotNull
    private String userZipcode;

    @Column(name = "user_city")
    @NotNull
    private String userCity;

    @Column(name = "user_state")
    @NotNull
    private String userState;

    @Column(name = "user_country")
    @NotNull
    private String userCountry;

    @Column(name = "user_profile")
    private long userProfile;

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
