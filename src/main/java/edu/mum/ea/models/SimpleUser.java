package edu.mum.ea.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("USER_SIMPLE")
public class SimpleUser extends UserRole {

    public SimpleUser(User user) {
        super(user);
    }
}
