package edu.mum.ea.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Post extends Activity {
    private String content;
    private boolean hasFilthyWord;
    @ManyToOne
    @JoinColumn(name = "comment_to")
    private Post commentTo;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Media> mediaItems = new ArrayList<>();
    @Transient
    private MultipartFile picture;
    @Transient
    private MultipartFile video;
    @Transient
    private boolean notifyFollowers;

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

    @JsonIgnore
    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }

    @JsonIgnore
    public MultipartFile getVideo() {
        return video;
    }

    public void setVideo(MultipartFile video) {
        this.video = video;
    }

    public boolean isHasFilthyWord() {
        return hasFilthyWord;
    }

    @JsonIgnore
    public boolean isNotifyFollowers() {
        return notifyFollowers;
    }

    public void setNotifyFollowers(boolean notifyFollowers) {
        this.notifyFollowers = notifyFollowers;
    }
}
