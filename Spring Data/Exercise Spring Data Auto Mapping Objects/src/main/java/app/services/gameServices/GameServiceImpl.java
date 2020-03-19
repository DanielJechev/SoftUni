package app.services.gameServices;

import app.domain.dtos.AddGameDto;
import app.domain.dtos.DeleteGameDto;
import app.domain.dtos.EditGameDto;
import app.domain.entities.Game;
import app.repositories.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
public class GameServiceImpl implements GameService{
    private GameRepository gameRepository;
    private ModelMapper mapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ModelMapper mapper) {
        this.gameRepository = gameRepository;
        this.mapper = mapper;
    }

    List<Game> getAllGames(){
        return this.gameRepository.findAll();
    }


    @Override
    public String addGame(AddGameDto addGameDto) {
        Validator validator = Validation
                .byDefaultProvider()
                .configure()
                .buildValidatorFactory()
                .getValidator();
        StringBuilder sb = new StringBuilder();

        if(validator.validate(addGameDto).size()>0){
            for(ConstraintViolation<AddGameDto> violation: validator.validate(addGameDto)) {
                sb.append(violation.getMessage()).append(System.lineSeparator());
            }
        }else{
            Game game = gameRepository.findByTitle(addGameDto.getTitle());
            if(game != null){
                sb.append("The game already exists.");
            }else{
                game=mapper.map(addGameDto, Game.class);
            }
            this.gameRepository.save(game);
            sb.append(String.format("Added %s", game.getTitle()));
        }

        return sb.toString();
    }

    @Override
    public String editGameProperty(EditGameDto editGameDto, long id) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        mapper.map(editGameDto, Game.class);
        Field[] fields = editGameDto.getClass().getDeclaredFields();
        Game gameToEdit = this.gameRepository.findById(id).orElse(null);
        if(gameToEdit == null){
            sb.append("Game doesn't exists.");
        }else{

            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object fieldValue = field.get(editGameDto);
                if(fieldValue != null){
                    updateGameField(gameToEdit.getId(), fieldName, fieldValue);

                }
            }
            sb.append("Edited ").append(gameToEdit.getTitle());
        }

        return sb.toString();
    }

    @Override
    public String deleteGame(DeleteGameDto deleteGameDto) {
        StringBuilder sb = new StringBuilder();
        mapper.map(deleteGameDto, Game.class);
        Game gameToDelete = this.gameRepository.findById(deleteGameDto.getId()).orElse(null);
        if(gameToDelete == null){
            sb.append("The game doesn't exists.");
        }else{
            this.gameRepository.delete(gameToDelete);
            sb.append("Deleted ").append(gameToDelete.getTitle());
        }
        return sb.toString();
    }

    private void updateGameField(long id, String fieldName, Object fieldValue) {
        switch(fieldName) {
            case "title":
                this.gameRepository.updateGameTitle(id, (String) fieldValue);
                break;
            case "trailer":
                this.gameRepository.updateGameTrailer(id, (String) fieldValue);
                break;
            case "url":
                this.gameRepository.updateGameUrl(id, (String) fieldValue);
                break;
            case "size":
                Double size = (Double) fieldValue;
                this.gameRepository.updateGameSize(id,size);
                break;
            case "price":
                BigDecimal price = (BigDecimal) fieldValue;
                this.gameRepository.updateGamePrice(id,price);
                break;
            case "description":
                this.gameRepository.updateGameDescription(id, (String)fieldValue);
                break;
            case "releaseDate":
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate releaseDate = LocalDate.parse((String) fieldValue, dtf);
                this.gameRepository.updateGameReleaseDate(id, releaseDate);
                break;
            default:
                break;
        }
    }


}
