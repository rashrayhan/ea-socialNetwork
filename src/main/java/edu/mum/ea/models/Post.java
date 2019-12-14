package edu.mum.ea.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Post extends Activity {
    private String content;
    private boolean hasFilthyWord;
    @ManyToOne
    @JoinColumn(name = "comment_to")
    private Post commentTo;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Media> mediaItems = new ArrayList<>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getHasFilthyWord() {
        return hasFilthyWord;
    }

    public void setHasFilthyWord(boolean hasFilthyWord) {
        this.hasFilthyWord = hasFilthyWord;
    }

    public Post getCommentTo() {
        return commentTo;
    }

    public void setCommentTo(Post commentTo) {
        this.commentTo = commentTo;
    }

    public List<Media> getMediaItems() {
        return mediaItems;
    }

    public void setMediaItems(List<Media> mediaItems) {
        this.mediaItems = mediaItems;
    }
}
