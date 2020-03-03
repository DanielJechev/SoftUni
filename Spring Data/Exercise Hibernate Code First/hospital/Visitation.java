package entities.gringotts.hospital;

import entities.gringotts.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity {
    private LocalDate date;
    private String comments;

    public Visitation() {
    }

    @Column(nullable = false)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}