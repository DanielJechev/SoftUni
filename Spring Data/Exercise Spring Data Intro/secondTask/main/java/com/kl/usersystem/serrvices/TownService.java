package com.kl.usersystem.serrvices;

import com.kl.usersystem.domain.entities.Town;

public interface TownService {
    void seedTowns();
    void persist(Town town);

    Town getTown(String townName);
}
