package com.kl.usersystem.repositories;

import com.kl.usersystem.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByFirstName(String firstName);

    List<User> getAllById(Integer id);

    List<User> getAllByEmailEndingWith(String string);

    List<User> getAllByLastTimeLoggedInBefore(LocalDateTime date);
}
