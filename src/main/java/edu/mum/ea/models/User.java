package edu.mum.ea.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
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
public class User implements UserDetails {
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
    @Column(name = "account_status", columnDefinition = ("varchar(16) not null"))
    private AccountStatus accountStatus;
    @Column(name = "profile_photo")
    private String profilePhoto;
    @Column(name = "cover_photo")
    private String coverPhoto;
    private String biography;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")

    private Address address;
    @ManyToMany
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    public User(String surname, String otherNames, LocalDate dateOfBirth, String email, String username, String password, AccountStatus accountStatus, String profilePhoto, String coverPhoto, String biography, Address address) {
        this.surname = surname;
        this.otherNames = otherNames;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.username = username;
        this.password = password;
        this.accountStatus = accountStatus;
        this.profilePhoto = profilePhoto;
        this.coverPhoto = coverPhoto;
        this.biography = biography;
        this.address = address;

    }

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

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
