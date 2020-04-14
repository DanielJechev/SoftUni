package alararestaurant.repository;

import alararestaurant.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);

    @Query(value = "SELECT c FROM Category c " +
            "GROUP BY c.name " +
            "ORDER BY size(c.items) DESC ")
    List<Category> findAllByItemsCount();
}
