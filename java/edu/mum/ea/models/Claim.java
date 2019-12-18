package edu.mum.ea.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Claim extends Activity{
    private String reason;
    private String description;
}
