package com.kl.usersystem.repositories;

import com.kl.usersystem.domain.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TownRepository extends JpaRepository<Town, Integer> {
    Town findByName(String townName);
}
