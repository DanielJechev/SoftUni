package com.car.dealer.repositories;

import com.car.dealer.domain.entities.Car;
import com.car.dealer.domain.dtos.views.toyotaCars.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query("SELECT new com.car.dealer.domain.dtos.views.toyotaCars.CarModel(c.id, c.make, c.model, c.travelledDistance) FROM Car  c " +
            "WHERE c.make = :make " +
            "ORDER BY c.model, c.travelledDistance DESC")
    List<CarModel> findAllCarsByMakeOrderByModelThenByDistance(@Param("make") String make);
}
