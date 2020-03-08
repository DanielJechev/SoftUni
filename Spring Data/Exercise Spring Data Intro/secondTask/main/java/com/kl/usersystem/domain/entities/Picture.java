package com.kl.usersystem.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {
    private String title;
    private String caption;
    private String path;

    public Picture() {
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "caption")
    public String getCaption() {
        return this.caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Column(name = "path", nullable = false)
    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
