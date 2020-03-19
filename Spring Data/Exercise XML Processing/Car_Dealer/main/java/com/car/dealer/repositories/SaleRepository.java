package com.car.dealer.repositories;

import com.car.dealer.domain.entities.Sale;
import com.car.dealer.domain.dtos.views.salesWithDiscount.SaleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
    @Query("SELECT new com.car.dealer.domain.dtos.views.salesWithDiscount.SaleModel(" +
            " s.car, s.customer.name, s.discount, (SELECT SUM(p.price) FROM s.car.parts p)) " +
            "FROM Sale s ")
    List<SaleModel> getSalesByDiscount();
}
