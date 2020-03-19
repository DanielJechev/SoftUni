package app.repositories;

import app.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByEmail(String email);

    @Transactional
    @Modifying
    @Query(value="update User u set u.role = 'ADMIN' where u.id = :id")
    void setUserAsAdmin(@Param(value = "id") long id);
}
