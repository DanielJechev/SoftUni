package softuni.exam.service;

import softuni.exam.domain.entities.Picture;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface PictureService {
    String importPictures() throws IOException, JAXBException;

    boolean areImported();

    String readPicturesXmlFile() throws IOException;

    Picture getPictureByUrl(String url);
}
