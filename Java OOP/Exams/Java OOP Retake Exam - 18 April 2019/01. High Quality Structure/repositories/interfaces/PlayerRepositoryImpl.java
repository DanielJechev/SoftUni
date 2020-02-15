package repositories.interfaces;

import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {
    private List<Player> players;

    public PlayerRepositoryImpl() {
        this.players = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return null;
    }

    @Override
    public void add(Player player) {

    }

    @Override
    public boolean remove(Player player) {
        return false;
    }

    @Override
    public Player find(String name) {
        return null;
    }
}
