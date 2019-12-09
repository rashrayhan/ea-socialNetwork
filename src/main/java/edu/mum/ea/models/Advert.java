package edu.mum.ea.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Advert extends Activity {
    private String title;
    private String content;
}
