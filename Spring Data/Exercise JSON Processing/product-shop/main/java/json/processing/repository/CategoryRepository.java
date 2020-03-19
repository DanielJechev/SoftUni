package json.processing.repository;

import json.processing.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

    @Query("SELECT c FROM Category c WHERE size(c.products) > 0 ORDER BY size(c.products) DESC")
    LinkedList<Category> categoriesByProductCount();
}
