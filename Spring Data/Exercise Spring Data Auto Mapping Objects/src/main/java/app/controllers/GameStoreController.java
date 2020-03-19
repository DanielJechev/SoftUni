package app.controllers;

import app.domain.dtos.*;
import app.services.gameServices.GameService;
import app.services.orderServices.OrderService;
import app.services.userServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class GameStoreController implements CommandLineRunner {
    private UserService userService;
    private GameService gameService;
    private OrderService orderService;
    private Scanner scanner;

    @Autowired
    public GameStoreController(UserService userService,
                               GameService gameService,
                               OrderService orderService,
                               Scanner scanner) {
        this.userService = userService;
        this.gameService = gameService;
        this.orderService = orderService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.print("Enter command/s: ");
        while(true){
            String[] input = scanner.nextLine().split("\\|");

            switch(input[0]){
                case "RegisterUser":
                    String email = input[1];
                    String password = input[2];
                    String confirmPassword = input[3];
                    String name = input[4];
                    if(this.userService.findUserByEmail(email) != null){
                        System.out.println("User already exists");
                        break;
                    }
                    if(password.equals(confirmPassword)){
                        RegisterUserDto registerUserDto = new RegisterUserDto(email, password,
                                confirmPassword, name);
                        System.out.println(this.userService.registerUser(registerUserDto));
                    }

                    break;
                case "LoginUser":
                    String loginEmail = input[1];
                    String loginPassword = input[2];
                    LoginUserDto loginUserDto = new LoginUserDto(loginEmail, loginPassword);
                    System.out.println(this.userService.loginUser(loginUserDto));
                    break;
                case "Logout":
                    System.out.println(this.userService.logoutUser());
                    break;
                case "AddGame":
                    String title = input[1];
                    BigDecimal price = new BigDecimal(input[2]);
                    Double size = Double.parseDouble(input[3]);
                    String trailerId = input[4];
                    String url = input[5];
                    String description = input[6];
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate releaseDate = LocalDate.parse(input[7], dtf);

                    AddGameDto addGameDto = new AddGameDto(title, price, size, trailerId, url,
                            description, releaseDate);

                    System.out.println(this.gameService.addGame(addGameDto));
                    break;
                case "EditGame":
                    EditGameDto editGameDto = new EditGameDto();
                    long id = Long.parseLong(input[1]);
                    editGameDto.setId(id);
                    for (int i = 2; i < input.length; i++) {
                        String[] elementToEdit = input[i].split("=");
                        String key = elementToEdit[0];
                        String value = elementToEdit[1];

                        setEditGameDtoProperty(editGameDto, key, value);
                        System.out.println(this.gameService.editGameProperty(editGameDto, id));

                    }
                    break;
                case "DeleteGame":
                    long idToDelete = Long.parseLong(input[1]);
                    DeleteGameDto deleteGameDto = new DeleteGameDto(idToDelete);
                    System.out.println(this.gameService.deleteGame(deleteGameDto));
                    break;
                default:
                    break;
            }

        }

    }

    private EditGameDto setEditGameDtoProperty(EditGameDto editGameDto, String key, String value) {
        switch(key){
            case "title":
                editGameDto.setTitle(value);
                break;
            case "trailer":
                editGameDto.setTrailer(value);
                break;
            case "url":
                editGameDto.setUrl(value);
                break;
            case "size":
                Double size = Double.parseDouble(value);
                editGameDto.setSize(size);
                break;
            case "price":
                BigDecimal price = new BigDecimal(value);
                editGameDto.setPrice(price);
                break;
            case "description":
                editGameDto.setDescription(value);
                break;
            case "releaseDate":
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate releaseDate = LocalDate.parse(value, dtf);
                editGameDto.setReleaseDate(releaseDate);
                break;
            default:
                break;
        }
        return editGameDto;
    }
}
