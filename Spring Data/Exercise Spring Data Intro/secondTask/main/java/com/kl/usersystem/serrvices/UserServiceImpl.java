package com.kl.usersystem.serrvices;

import com.kl.usersystem.domain.entities.Town;
import com.kl.usersystem.domain.entities.User;
import com.kl.usersystem.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final TownService townService;

    public UserServiceImpl(UserRepository userRepository, TownService townService) {
        this.userRepository = userRepository;
        this.townService = townService;
    }

    @Override
    public void persist(User user) {
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public User findById(Integer id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public void addFriend(User user, User friendToAdd) {
        User userFromDb = this.findById(user.getId());
        User friend = this.findById(friendToAdd.getId());

        final boolean[] isAlreadyFriend = {false};

        if (userFromDb != null && friend != null) {
            user.getFriends().forEach(f -> {
                if (f.getUsername().equals(friend.getUsername()) || user.getUsername().equals(friend.getUsername())) {
                    isAlreadyFriend[0] = true;
                }
            });
            if (!isAlreadyFriend[0]) {
                user.getFriends().add(friend);
                User savedUser = this.userRepository.saveAndFlush(user);
//                System.out.println(savedUser.getFriends().size());
            }
        }
    }

    @Override
    public void printFriends(User user) {
        final int[] index = {0};
        user.getFriends()
                .forEach(f -> {
                    index[0]++;
                    System.out.println("############## " + index[0] + ". Friend Name: " + f.getFullName());
                });
    }

    @Override
    public void printUsersByEmailProvider(String emailProvider) {
        if(emailProvider.length() > 0){
            List<User> users = this.userRepository.getAllByEmailEndingWith(emailProvider);
            if(users.size() > 0){
                users.forEach(u -> System.out.printf("## %s %s\n", u.getUsername(), u.getEmail()));
            }else{
                System.out.printf("## No users found with email domain %s\n", emailProvider);
            }
        }else{
            System.out.println("## Invalid input.");
        }

    }

    @Override
    public void removeInactiveUsers(String input) {
        try{
            String dateTimeStr = input + " 00:00";
            LocalDateTime date = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("d MMM yyyy HH:mm"));
            List<User> allByLastTimeLoggedInBefore = this.userRepository.getAllByLastTimeLoggedInBefore(date);

            final int[] count = {0};
            allByLastTimeLoggedInBefore.forEach(user -> {
                if(!user.getIs_deleted()){
                    count[0]++;
                    user.setIs_deleted(true);
                }
            });

            if(count[0] > 0){
                System.out.printf("## %d users have been deleted.\n", count[0]);
            }else{
                System.out.println("## No users have been deleted.");
            }
        }catch (Exception e){
            System.out.println("## Invalid date format.");
        }

    }

    @Override
    public void seedUsers() {
        // Add User
        User user = new User();
        user.setUsername("pesho123");
        user.setPassword("paS21@");
        user.setEmail("pesho@gmail.com");
        user.setAge(25);
        user.setIs_deleted(false);
        user.setLastTimeLoggedIn(LocalDateTime.parse("1986-04-08 12:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

        // Add town
        String birthTownName = "Sofia";
        String currentTownName = "Plovdiv";
        Town birthTown = this.townService.getTown(birthTownName);
        Town currentTown = this.townService.getTown(currentTownName);
        user.setBirthTown(birthTown);
        user.setCurrentlyLivingTown(currentTown);

        // Add firstName and LastName
        String firstName = "Pesho";
        String lastName = "Peshev";
        user.setFirstName(firstName);
        user.setLastName(lastName);

        this.persist(user);

        //#########################################
        // Add User 2
        User user2 = new User();
        user2.setUsername("vanko1");
        user2.setPassword("stpaS21@");
        user2.setEmail("vanko1@gmail.com");
        user2.setAge(35);
        user2.setIs_deleted(false);
        user2.setLastTimeLoggedIn(LocalDateTime.parse("2015-04-08 12:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

        // Add town
        String birthTownName2 = "Sofia";
        String currentTownName2 = "Plovdiv";
        Town birthTown2 = this.townService.getTown(birthTownName2);
        Town currentTown2 = this.townService.getTown(currentTownName2);
        user2.setBirthTown(birthTown2);
        user2.setCurrentlyLivingTown(currentTown2);

        // Add firstName and LastName
        String firstName2 = "Ivan";
        String lastName2 = "Ivanov";
        user2.setFirstName(firstName2);
        user2.setLastName(lastName2);

        this.persist(user2);

        //#########################################
        // Add User 3

        User user3 = new User();
        user3.setUsername("goshko_n00b");
        user3.setPassword("stpaS21@");
        user3.setEmail("gn00b@gmail.com");
        user3.setAge(35);
        user3.setIs_deleted(false);
        user3.setLastTimeLoggedIn(LocalDateTime.parse("2017-04-08 12:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

        // Add town
        String birthTownName3 = "Madrid";
        String currentTownName3 = "London";
        Town birthTown3 = this.townService.getTown(birthTownName3);
        Town currentTown3 = this.townService.getTown(currentTownName3);
        user3.setBirthTown(birthTown3);
        user3.setCurrentlyLivingTown(currentTown3);

        // Add firstName and LastName
        String firstName3 = "Gosho";
        String lastName3 = "Goshev";
        user3.setFirstName(firstName3);
        user3.setLastName(lastName3);

        this.persist(user3);

        //#########################################
        // Add User 4
        User user4 = new User();
        user4.setUsername("penbo");
        user4.setPassword("stpaS21@");
        user4.setEmail("pen@yahoo.co.uk");
        user4.setAge(35);
        user4.setIs_deleted(false);
        user4.setLastTimeLoggedIn(LocalDateTime.parse("2013-06-12 12:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

        // Add town
        String birthTownName4 = "Sofia";
        String currentTownName4 = "Plovdiv";
        Town birthTown4 = this.townService.getTown(birthTownName4);
        Town currentTown4 = this.townService.getTown(currentTownName4);
        user4.setBirthTown(birthTown4);
        user4.setCurrentlyLivingTown(currentTown4);

        // Add firstName and LastName
        String firstName4 = "Penko";
        String lastName4 = "Penkov";
        user4.setFirstName(firstName4);
        user4.setLastName(lastName4);

        this.persist(user4);

        //#########################################
        // Add User 5
        User user5 = new User();
        user5.setUsername("catLady");
        user5.setPassword("stpaS21@");
        user5.setEmail("stepheny.p@yahoo.co.uk");
        user5.setAge(35);
        user5.setIs_deleted(false);
        user5.setLastTimeLoggedIn(LocalDateTime.parse("2008-04-08 12:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

        // Add town
        String birthTownName5 = "Madrid";
        String currentTownName5 = "London";
        Town birthTown5 = this.townService.getTown(birthTownName5);
        Town currentTown5 = this.townService.getTown(currentTownName5);
        user5.setBirthTown(birthTown5);
        user5.setCurrentlyLivingTown(currentTown5);

        // Add firstName and LastName
        String firstName5 = "Stef";
        String lastName5 = "Anders";
        user5.setFirstName(firstName5);
        user5.setLastName(lastName5);

        this.persist(user5);
    }
}
