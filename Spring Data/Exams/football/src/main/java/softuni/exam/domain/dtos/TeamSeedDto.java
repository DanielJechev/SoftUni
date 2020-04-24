package softuni.exam.domain.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "team")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamSeedDto {

    @XmlElement(name = "name")
    @Expose
    private String name;
    @XmlElement(name = "picture")
    @Expose
    private PictureSeedDto picture;

    public TeamSeedDto() {
    }

    @Length(min = 3, max = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public PictureSeedDto getPicture() {
        return picture;
    }

    public void setPicture(PictureSeedDto picture) {
        this.picture = picture;
    }
}
