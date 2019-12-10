package edu.mum.ea.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Post extends Activity {

    private String content;
    @ManyToOne
    @JoinColumn(name = "comment_to")
    private Post commentTo;

    public Post(String content) {
        this.content = content;

    }
}
