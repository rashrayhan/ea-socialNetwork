package edu.mum.ea.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Advert extends Activity {
    @NotEmpty
    private String title;
    private String content;
    @OneToMany(mappedBy = "advert", cascade = CascadeType.PERSIST)
    private List<Media> mediaList= new ArrayList<>();

    private String target_users;

    @Transient
    private MultipartFile[] pictures;
    @Transient
    private MultipartFile[] videos;

    @JsonIgnore
    public MultipartFile[] getPictures() {
        return pictures;
    }

    public void setPictures(MultipartFile[] pictures) {
        this.pictures = pictures;
    }

    @JsonIgnore
    public MultipartFile[] getVideos() {
        return videos;
    }

    public void setVideos(MultipartFile[] videos) {
        this.videos = videos;
    }

    public String getTarget_users() {
        return target_users;
    }

    public void setTarget_users(String target_users) {
        this.target_users = target_users;
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<Media> mediaList) {
        this.mediaList = mediaList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
