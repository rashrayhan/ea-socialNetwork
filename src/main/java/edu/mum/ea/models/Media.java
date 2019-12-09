package edu.mum.ea.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Media {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filePath;
    @Column(name = "media_type", columnDefinition = "varchar(16) not null")
    private MediaType mediaType;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;
}
