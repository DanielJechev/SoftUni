package models;

import repositories.interfaces.CardRepository;

public class Advanced extends BasePlayer {
    public Advanced(CardRepository cardRepository, String username) {
        super(cardRepository, username, 250);
    }
}