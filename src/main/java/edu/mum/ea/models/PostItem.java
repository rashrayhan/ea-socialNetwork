package edu.mum.ea.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PostItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "item_type", columnDefinition = "varchar(16) not null")
    private PostItemType postItemType;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User performedUser;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
