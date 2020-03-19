package com.car.dealer.services.base;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface SaleService {
    void seedSales();

    void getSalesByDiscount() throws IOException, JAXBException;
}
