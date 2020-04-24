package softuni.exam.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T convertFromFile(String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException;

}
