package repositories.interfaces;

import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.ArrayList;
import java.util.List;

public class CardRepositoryImpl implements CardRepository {
    private List<Card> cards;

    public CardRepositoryImpl() {
        this.cards = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.cards.size();
    }

    @Override
    public List<Card> getCards() {
        return null;
    }

    @Override
    public void add(Card card) {

    }

    @Override
    public boolean remove(Card card) {
        return false;
    }

    @Override
    public Card find(String name) {
        return null;
    }
}