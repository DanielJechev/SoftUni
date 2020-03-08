package com.kl.usersystem.serrvices;

import com.kl.usersystem.domain.entities.User;

public interface UserService {
    void seedUsers();

    void persist(User user);

    User findById(Integer id);

    void addFriend(User user, User friendToAdd);

    void printFriends(User user);

    void printUsersByEmailProvider(String emailProvider);

    void removeInactiveUsers(String date);
}
