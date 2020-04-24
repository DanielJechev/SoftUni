package softuni.exam.service;

import softuni.exam.domain.entities.Player;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface PlayerService {
    String importPlayers() throws FileNotFoundException;

    boolean areImported();

    String readPlayersJsonFile() throws IOException;

    String exportPlayersWhereSalaryBiggerThan();

    String exportPlayersInATeam();

    Player getPlayerByFirstAndLastName(String firstName, String lastName);

}
