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



    public Post() {
        super();
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getCommentTo() {
        return commentTo;
    }

    public void setCommentTo(Post commentTo) {
        this.commentTo = commentTo;
    }
}
