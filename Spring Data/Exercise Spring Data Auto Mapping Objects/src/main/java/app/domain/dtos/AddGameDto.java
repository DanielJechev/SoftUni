package app.domain.dtos;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AddGameDto {
    private String title;
    private BigDecimal price;
    private Double size;
    private String trailer;
    private String url;
    private String description;
    private LocalDate releaseDate;

    public AddGameDto(String title, BigDecimal price,
                      Double size, String trailer,
                      String url, String description,
                      LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.url = url;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Pattern(regexp = "^[A-Z].*", message = "Title must start with uppercase letter.")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 symbols.")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Digits(integer = 5, fraction = 2)
    @Positive(message = "Price must be positive.")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Digits(integer = 7, fraction = 1)
    @Positive(message = "Size must be positive.")
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Size(min = 11, max = 11)
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Pattern(regexp = "^https?:\\/\\/.+$")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Size(min=20)
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
}
