package com.car.dealer.utils;

import com.car.dealer.utils.base.JaxbUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class JaxbUtilImpl implements JaxbUtil {
    private final String BASE_PATH = "src/main/resources/";
    private final String INPUT_PATH = BASE_PATH + "input/";
    private final String OUTPUT_PATH = BASE_PATH + "output/";

    public <T> void saveToXML(String fileName, T item) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(item.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        try (FileWriter fw = new FileWriter(OUTPUT_PATH + fileName + ".xml");
             BufferedWriter bw = new BufferedWriter(fw)) {
            marshaller.marshal(item, bw);
        }
    }

    public <T> T unmarshXML(String fileName, Class<T> type) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(type);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        try (FileReader fr = new FileReader(INPUT_PATH + fileName + ".xml");
             BufferedReader br = new BufferedReader(fr)) {
            return (T) unmarshaller.unmarshal(br);
        }
    }
}
