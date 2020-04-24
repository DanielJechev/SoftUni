package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.domain.dtos.PictureSeedRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static softuni.exam.constants.GlobalConstants.*;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final XmlParser xmlParser;


    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, XmlParser xmlParser) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
    }


    @Override
    public String importPictures() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        PictureSeedRootDto pictureSeedRootDto = this.xmlParser
                .convertFromFile(PICTURES_FILE_PATH, PictureSeedRootDto.class);

        pictureSeedRootDto
                .getPictureSeedDtos()
                .forEach(pictureSeedDto -> {
                    if (this.validatorUtil.isValid(pictureSeedDto)) {
                        if (this.pictureRepository.findByUrl(pictureSeedDto.getUrl()) == null) {
                            Picture picture = this.modelMapper.map(pictureSeedDto, Picture.class);

                            this.pictureRepository.saveAndFlush(picture);
                            stringBuilder.append(String.format(VALID_DATA_MSG,
                                    picture.getClass().getSimpleName().toLowerCase(), picture.getUrl() ))
                                    .append(System.lineSeparator());
                        } else {
                            stringBuilder.append("Already in DB")
                                    .append(System.lineSeparator());
                        }
                    } else {
                        stringBuilder.append("Invalid Picture")
                                .append(System.lineSeparator());
                    }
                });

        return stringBuilder.toString();
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return Files.readString(Paths.get(PICTURES_FILE_PATH));
    }

    @Override
    public Picture getPictureByUrl(String url) {
        return this.pictureRepository.findByUrl(url);
    }

}
