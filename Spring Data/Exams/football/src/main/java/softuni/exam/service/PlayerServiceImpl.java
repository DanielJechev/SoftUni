package softuni.exam.service;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.PlayerSeedDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.util.ValidatorUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.constants.GlobalConstants.PLAYERS_FILE_PATH;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;
    private final PictureService pictureService;
    private final TeamService teamService;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson, PictureService pictureService, TeamService teamService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
        this.pictureService = pictureService;
        this.teamService = teamService;
    }

    @Override
    public String importPlayers() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        PlayerSeedDto[] playerSeedDto = this.gson
                .fromJson(new FileReader(PLAYERS_FILE_PATH), PlayerSeedDto[].class);

        Arrays.stream(playerSeedDto)
                .forEach(dto -> {
                    if (this.validatorUtil.isValid(dto)) {
                        if (this.playerRepository
                                .findByFirstNameAndLastName(dto.getFirstName(), dto.getLastName()) == null) {

                            Player player = this.modelMapper.map(dto, Player.class);

                            Team team = this.teamService.getByName(dto.getTeam().getName());
                            Picture picture = this.pictureService
                                    .getPictureByUrl(dto.getPicture().getUrl());

                            player.setTeam(team);
                            player.setPicture(picture);

                            this.playerRepository.saveAndFlush(player);

                            sb.append(String.format("Successfully imported player: %s %s",
                                    dto.getFirstName(), dto.getLastName()))
                                    .append(System.lineSeparator());

                        } else {
                            sb.append("Already in DB")
                                    .append(System.lineSeparator());
                        }
                    } else {
                        sb.append("Invalid player")
                                .append(System.lineSeparator());
                    }
                });


        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        StringBuilder sb = new StringBuilder();

        this.playerRepository
                .findAllBySalaryIsGreaterThanOrderBySalaryDesc(BigDecimal.valueOf(100000))
                .forEach(player -> {
                    sb.append(String.format("Player name: %s %s \n" +
                                    "Number: %d\n" +
                                    "Salary: %.2f\n" +
                                    "Team: %s", player.getFirstName(),
                            player.getLastName(), player.getNumber(), player.getSalary(),
                            player.getTeam().getName()))
                            .append(System.lineSeparator());

                });

        return sb.toString();
    }

    @Override
    public String exportPlayersInATeam() {
        StringBuilder sb = new StringBuilder();

        this.playerRepository
                .findAllByTeamName("North Hub")
                .forEach(player -> {
                    sb.append(String.format("Player name: %s " +
                                    "%s - %s\n" +
                                    "Number: %d\n", player.getFirstName(),
                            player.getLastName(), player.getPosition(), player.getNumber()))
                            .append(System.lineSeparator());

                });

        return sb.toString();
    }

    @Override
    public Player getPlayerByFirstAndLastName(String firstName, String lastName) {
        return this.playerRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
