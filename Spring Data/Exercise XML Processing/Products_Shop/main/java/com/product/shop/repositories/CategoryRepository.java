package com.product.shop.repositories;

import com.product.shop.domain.entities.Category;
import com.product.shop.domain.dtos.views.categoriesByProductsCount.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT " +
            "new com.product.shop.domain.dtos.views.categoriesByProductsCount.CategoryModel(c.name, " +
            "SIZE(c.products), " +
            "(SELECT AVG(cat.price) FROM c.products cat), " +
            "(SELECT SUM(cat.price) FROM c.products cat)) " +
            "FROM Category c " +
            "GROUP BY c.id " +
            "ORDER BY SIZE(c.products) DESC")
    List<CategoryModel> getCategoriesByProductsCount();
}
