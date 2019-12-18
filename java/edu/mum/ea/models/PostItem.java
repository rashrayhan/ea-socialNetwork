package edu.mum.ea.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PostItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "item_type")
    private PostItemType postItemType;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User performedUser;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
