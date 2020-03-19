package com.product.shop.repositories;

import com.product.shop.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u " +
            "FROM User u " +
            "WHERE SIZE(u.soldProducts) >= 1 " +
            "ORDER BY SIZE(u.soldProducts) DESC, " +
            "u.lastName ASC"
    )
    List<User> getAllUsersProducts();
}
