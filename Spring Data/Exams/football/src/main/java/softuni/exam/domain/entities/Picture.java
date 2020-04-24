package softuni.exam.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{
    private String url;

    public Picture() {
    }

    @Column(name = "url", unique = true)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
