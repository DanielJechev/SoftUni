package com.kl.usersystem.util.entetiesSeed;



import com.kl.usersystem.repositories.TownRepository;
import com.kl.usersystem.repositories.UserRepository;
import com.kl.usersystem.serrvices.TownService;
import com.kl.usersystem.serrvices.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class EntitiesSeedExecutor {

    private final UserRepository userRepository;
    private final TownRepository townRepository;
    private final TownService townService;
    private final UserService userService;


    public EntitiesSeedExecutor(UserRepository userRepository, TownRepository townRepository, TownService townService, UserService userService) {
        this.userRepository = userRepository;
        this.townRepository = townRepository;
        this.townService = townService;
        this.userService = userService;
    }


    @PostConstruct
    public void insertEntities() throws IOException {
        if(townRepository.count() == 0){
            this.townService.seedTowns();
        }

        if(userRepository.count() == 0){
            this.userService.seedUsers();
        }
    }




}
