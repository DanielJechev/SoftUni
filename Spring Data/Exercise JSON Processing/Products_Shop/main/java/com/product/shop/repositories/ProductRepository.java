package com.product.shop.repositories;

import com.product.shop.domain.entities.Product;
import com.product.shop.domain.entities.User;
import com.product.shop.domain.dtos.views.ProductInRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT new com.product.shop.domain.dtos.views.ProductInRange(p.name, " +
            "   p.price, " +
            "   CONCAT(p.seller.firstName, ' ', p.seller.lastName)) " +
            "FROM Product p " +
            "WHERE p.price BETWEEN :lowBound AND :highBound " +
            " AND p.buyer IS NULL " +
            "ORDER BY p.price")
    List<ProductInRange> getAllProductsInRangeWithoutBuyer(@Param("lowBound") BigDecimal lowBound, @Param("highBound") BigDecimal highBound);

    @Query("SELECT u " +
            "FROM Product p " +
            "INNER JOIN User u ON p.seller.id = u.id " +
            "WHERE p.buyer IS NOT NULL " +
            "GROUP BY u.id " +
            "ORDER BY u.lastName ASC, " +
            "   u.firstName ASC")
    List<User> getSuccessfullySoldProductsByUsers();
}
