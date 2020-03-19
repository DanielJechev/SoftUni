package app.domain.dtos;

import app.domain.entities.Game;
import org.modelmapper.*;
import org.modelmapper.spi.*;

import javax.print.attribute.standard.Destination;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class EditGameDto {
    private Long id;
    private String title;
    private String trailer;
    private String url;
    private Double size;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    public EditGameDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void initMapping(ModelMapper mapper){
        TypeMap<EditGameDto, Game> editGameTypeMap = mapper.createTypeMap(EditGameDto.class, Game.class);


        editGameTypeMap.addMappings(m->m.skip((game, o) -> game.setId((long)o)));
    }
}
