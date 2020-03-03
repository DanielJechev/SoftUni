package entities.gringotts.hospital;

import entities.gringotts.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {
    private String name;
    private String comments;

    public Diagnose() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}