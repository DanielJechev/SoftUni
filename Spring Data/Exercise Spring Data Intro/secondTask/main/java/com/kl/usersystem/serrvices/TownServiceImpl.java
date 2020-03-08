package com.kl.usersystem.serrvices;

import com.kl.usersystem.domain.entities.Town;
import com.kl.usersystem.domain.entities.User;
import com.kl.usersystem.repositories.TownRepository;
import com.kl.usersystem.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;

    public TownServiceImpl(UserRepository userRepository, TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public void persist(Town town) {
        this.townRepository.saveAndFlush(town);
    }

    @Override
    public Town getTown(String townName) {
        Town townByName = this.townRepository.findByName(townName);
        if(townByName == null){
            Town town = new Town();
            town.setName(townName);
            this.persist(town);
        }
        return townByName;
    }

    @Override
    public void seedTowns() {
            Town town = new Town();
            town.setName("Sofia");
            town.setCountry("Bulgaria");

            Town town2 = new Town();
            town2.setName("Plovdiv");
            town2.setCountry("Bulgaria");

            Town town3 = new Town();
            town3.setName("London");
            town3.setCountry("England");

            Town town4 = new Town();
            town4.setName("Madrid");
            town4.setCountry("Spain");

            this.townRepository.saveAndFlush(town);
            this.townRepository.saveAndFlush(town2);
            this.townRepository.saveAndFlush(town3);
            this.townRepository.saveAndFlush(town4);
    }
}
