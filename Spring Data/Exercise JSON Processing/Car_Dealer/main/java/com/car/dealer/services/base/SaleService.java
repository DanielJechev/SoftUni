package com.car.dealer.services.base;

import java.io.IOException;

public interface SaleService {
    void seedSales();

    void getSalesByDiscount() throws IOException;
}
