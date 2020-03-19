package app.domain.dtos;

public class DeleteGameDto {
    private long id;

    public DeleteGameDto(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
