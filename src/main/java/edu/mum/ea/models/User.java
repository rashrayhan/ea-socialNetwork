package edu.mum.ea.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "system_user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surname;
    @Column(name = "other_names")
    private String otherNames;
    @DateTimeFormat(pattern = "yyyy-dd-MM")
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
    @ManyToOne
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

    public List<Role> getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
