package edu.mum.ea.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "system_role")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "role_privilege",
    joinColumns = @JoinColumn(name = "role_id"),
    inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    private List<Privilege> privileges = new ArrayList<>();

    public Role(String name, List<User> users, List<Privilege> privileges) {
        this.name = name;
        this.users = users;
        this.privileges = privileges;
    }
}
