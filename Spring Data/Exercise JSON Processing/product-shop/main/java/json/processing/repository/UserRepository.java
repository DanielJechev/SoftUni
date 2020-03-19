package json.processing.repository;

import json.processing.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT distinct p.seller FROM Product p WHERE p.buyer IS NOT NULL")
    List<User> usersWithAtLeastOneSoldProduct();

    @Query("SELECT u FROM User u WHERE size(u.sellingProducts) > 0 ORDER BY size(u.sellingProducts) DESC, u.lastName ASC ")
    List<User> usersWithSoldProduct();

}
