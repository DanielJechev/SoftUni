package car.dealer.demo.repository;

import car.dealer.demo.model.dto.viewModel.query2Dtos.CarDto;
import car.dealer.demo.model.dto.viewModel.query4.CarViewModel;
import car.dealer.demo.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT new car.dealer.demo.model.dto.viewModel.query2Dtos.CarDto(c.id, c.make, c.model, c.travelledDistance) " +
            "FROM Car c WHERE c.make LIKE :make ORDER BY c.model ASC, c.travelledDistance DESC")
    List<CarDto> findAllByMakeOrderByModel(@Param("make") String make);

}
