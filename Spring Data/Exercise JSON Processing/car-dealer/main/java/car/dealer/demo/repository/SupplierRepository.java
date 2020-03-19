package car.dealer.demo.repository;

import car.dealer.demo.model.dto.viewModel.query3.LocalSupplierDto;
import car.dealer.demo.model.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {


    @Query("SELECT new car.dealer.demo.model.dto.viewModel.query3.LocalSupplierDto(s.id, s.name, count(p.id) ) " +
            "FROM Supplier AS s JOIN s.parts AS p " +
            "WHERE s.importer = FALSE " +
            "GROUP BY s.id")
    List<LocalSupplierDto> selectAllLocalSuppliers();
}
