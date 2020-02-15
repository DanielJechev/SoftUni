package models.battleFields.interfaces;

import models.players.interfaces.Player;

public interface Battlefield {
    void fight(Player attackPlayer, Player enemyPlayer);
}
