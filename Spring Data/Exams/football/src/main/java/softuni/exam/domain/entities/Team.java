package softuni.exam.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{
   private String name;
   private Picture picture;

    public Team() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
