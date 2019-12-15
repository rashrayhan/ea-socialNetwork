package edu.mum.ea.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Activity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "activity_time")
    private LocalDateTime activityTime;

<<<<<<< HEAD
=======
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

>>>>>>> 7116a2cf423565ac8e55fba271e3b7d359d5571e
    public LocalDateTime getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(LocalDateTime activityTime) {
        this.activityTime = activityTime;
    }
<<<<<<< HEAD

=======
>>>>>>> 7116a2cf423565ac8e55fba271e3b7d359d5571e
}
