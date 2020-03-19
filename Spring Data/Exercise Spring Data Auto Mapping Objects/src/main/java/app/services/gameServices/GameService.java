package app.services.gameServices;

import app.domain.dtos.AddGameDto;
import app.domain.dtos.DeleteGameDto;
import app.domain.dtos.EditGameDto;
import app.domain.entities.Game;
import app.repositories.GameRepository;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
    String addGame(AddGameDto addGameDto);

    String editGameProperty(EditGameDto editGameDto, long id) throws IllegalAccessException;

    String deleteGame(DeleteGameDto deleteGameDto);
}
