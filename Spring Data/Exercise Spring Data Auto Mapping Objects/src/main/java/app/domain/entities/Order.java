package app.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    private long id;
    private User buyer;
    private List<Game> orderedGames;

    public Order() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    @ManyToMany
    @JoinTable(name="orders_games",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="game_id", referencedColumnName = "id"))
    public List<Game> getOrderedGames() {
        return orderedGames;
    }

    public void setOrderedGames(List<Game> orderedGames) {
        this.orderedGames = orderedGames;
    }
}
