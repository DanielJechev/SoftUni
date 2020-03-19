package car.dealer.demo.repository;

import car.dealer.demo.model.dto.viewModel.query5.CustomerViewModelQuery5;
import car.dealer.demo.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> getAllByOrderByBirthDateAscYoungDriverDesc();

    @Query("SELECT c FROM Customer c WHERE size(c.sales) > 0")
    List<Customer> getAllWithMinOneBoughtCar();
}
