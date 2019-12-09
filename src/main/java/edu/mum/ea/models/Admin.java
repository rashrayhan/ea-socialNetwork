package edu.mum.ea.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("USER_ADMIN")
public class Admin extends UserRole{

}
