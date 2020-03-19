package com.car.dealer.repositories;

import com.car.dealer.domain.entities.Supplier;
import com.car.dealer.domain.dtos.views.LocalSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    @Query("SELECT new com.car.dealer.domain.dtos.views.LocalSupplier(s.id, s.name, SIZE(s.parts)) " +
            "FROM Supplier s " +
            "WHERE s.isImporter = false " +
            "GROUP BY s.id ")
    List<LocalSupplier> getAllSuppliersThatDoNotImportPartsFromAbroad();
}
