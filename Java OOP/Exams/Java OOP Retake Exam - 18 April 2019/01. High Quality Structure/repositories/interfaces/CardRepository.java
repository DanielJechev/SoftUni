package repositories.interfaces;

import models.cards.interfaces.Card;
import java.util.List;

public interface CardRepository {
    int getCount();

    List<Card> getCards();

    void add(Card card);

    boolean remove(Card card);

    Card find(String name);
}
