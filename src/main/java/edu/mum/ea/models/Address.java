package edu.mum.ea.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String state;
    private String city;
    @Column(name = "zip_code")
    private String zipCode;

    public Address(String country, String state, String city, String zipCode) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Address() {
    }
}
