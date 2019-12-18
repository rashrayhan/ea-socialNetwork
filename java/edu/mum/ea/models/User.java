package edu.mum.ea.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "system_user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surname;
    @Column(name = "other_names")
    private String otherNames;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private String email;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "account_status")
    private AccountStatus accountStatus;
    @Column(name = "profile_photo")
    private String profilePhoto;
    @Column(name = "cover_photo")
    private String coverPhoto;
    private String biography;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")

    private Address address;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public String getBiography() {
        return biography;
    }

    public Address getAddress() {
        return address;
    }

    @JsonIgnore
    public List<Role> getRoles() {
        return roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}