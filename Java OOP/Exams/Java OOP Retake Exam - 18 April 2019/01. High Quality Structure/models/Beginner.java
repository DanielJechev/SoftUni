package models;

import repositories.interfaces.CardRepository;

public class Beginner extends BasePlayer {


    public Beginner(CardRepository cardRepository, String username) {
        super(cardRepository, username, 50);
    }
}

