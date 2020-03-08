package com.kl.usersystem.domain.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album extends BaseEntity{
    private String name;
    private String backgroundColor;
    private Boolean isPublic;
    private Set<Picture> pictures;
    private User user;

    public Album() {
        this.pictures = new HashSet<>();
    }


    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "background_color", nullable = false)
    public String getBackgroundColor() {
        return this.backgroundColor;
    }


    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }


    @Column(name = "is_public", nullable = false , columnDefinition = "BOOLEAN DEFAULT FALSE")
    public Boolean getPublic() {
        return this.isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    @ManyToMany()
    @JoinTable(name = "albums_pictures",
            joinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "picture_id", referencedColumnName = "id"))
    public Set<Picture> getPictures() {
        return this.pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
}
