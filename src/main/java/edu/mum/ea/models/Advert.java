package edu.mum.ea.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Advert extends Activity {
    @NotEmpty
    private String title;
    private String content;
    @OneToMany(mappedBy = "advert", cascade = CascadeType.ALL)
    private List<Media> mediaList= new ArrayList<>();
    private String target_users;

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
