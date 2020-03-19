package com.product.shop.utils.base;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface JaxbUtil {
    <T> void saveToXML(String fileName, T item) throws JAXBException, IOException;

    <T> T unmarshXML(String fileName, Class<T> type) throws JAXBException, IOException;
}
