package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.TeamSeedRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.GlobalConstants.*;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final PictureService pictureService;
    private final PictureRepository pictureRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, XmlParser xmlParser, PictureService pictureService, PictureRepository pictureRepository) {
        this.teamRepository = teamRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.pictureService = pictureService;
        this.pictureRepository = pictureRepository;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        TeamSeedRootDto teamSeedRootDto = this.xmlParser
                .convertFromFile(TEAMS_FILE_PATH, TeamSeedRootDto.class);

        teamSeedRootDto.getTeams()
                .forEach(teamSeedDto -> {
                    if (this.validatorUtil.isValid(teamSeedDto)) {
                        if (this.teamRepository.findByName(teamSeedDto.getName()) == null) {
                            Team team = this.modelMapper.map(teamSeedDto, Team.class);

                            Picture picture = this.pictureService
                                    .getPictureByUrl(team.getPicture().getUrl());

                            team.setPicture(picture);

                            this.teamRepository.saveAndFlush(team);

                            sb.append("Successfully imported - ")
                                    .append(team.getName())
                                    .append(System.lineSeparator());
                        } else {
                            sb.append("Already in DB")
                                    .append(System.lineSeparator());
                        }
                    } else {
                        sb.append("Invalid team")
                                .append(System.lineSeparator());
                    }
                });

        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public Team getByName(String name) {
        return this.teamRepository.findByName(name);
    }
}
