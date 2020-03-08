package com.kl.usersystem.terminal;

import com.kl.usersystem.domain.entities.Album;
import com.kl.usersystem.domain.entities.Picture;
import com.kl.usersystem.domain.entities.User;
import com.kl.usersystem.serrvices.AlbumService;
import com.kl.usersystem.serrvices.PictureService;
import com.kl.usersystem.serrvices.TownService;
import com.kl.usersystem.serrvices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
@Transactional
public class Terminal implements CommandLineRunner {
    private final UserService userService;
    private final TownService townService;
    private final PictureService pictureService;
    private final AlbumService albumService;

    @Autowired
    public Terminal(UserService userService, TownService townService, PictureService pictureService, AlbumService albumService) {
        this.userService = userService;
        this.townService = townService;
        this.pictureService = pictureService;
        this.albumService = albumService;
    }


    @Override
    public void run(String... args) throws Exception {
        //#####################################
        // 5 Users and 3 Tows are automatically seeded
        // if users.count() == 0 or towns.count() == 0
        // (EntitiesSeedExecutor.class)
        //#####################################

        //#####################################
        // find User By id

        User userById = this.userService.findById(1);
        System.out.println("########### Full name: " + userById.getFullName());

        //#####################################
        // Add friends

        User userById1 = this.userService.findById(1);
        User userById2 = this.userService.findById(2);
        User userById3 = this.userService.findById(3);

        this.userService.addFriend(userById1, userById2);
        this.userService.addFriend(userById1, userById3);
        this.userService.addFriend(userById1, userById1);

        // Print all Friends
        this.userService.printFriends(userById1);

        //#####################################
        // Create Pictures

        Picture picture1 = new Picture();
        picture1.setTitle("pic1");
        picture1.setCaption("cat");
        picture1.setPath("C:\\Desktop\\cat.png");

        Picture picture2 = new Picture();
        picture2.setTitle("pic2");
        picture2.setCaption("dog");
        picture2.setPath("C:\\Desktop\\dog.png");

        Picture picture3 = new Picture();
        picture3.setTitle("pic3");
        picture3.setCaption("car");
        picture3.setPath("C:\\Desktop\\car.png");

        this.pictureService.persistPicture(picture1);
        this.pictureService.persistPicture(picture2);
        this.pictureService.persistPicture(picture3);

        //#####################################
        // Create Album

        Album album = new Album();
        album.setName("first_Album");
        album.setBackgroundColor("red");
        album.setPublic(true);
        album.getPictures().add(picture1);
        album.getPictures().add(picture2);
        album.getPictures().add(picture3);

        this.albumService.persistAlbum(album);

        Album album2 = new Album();
        album2.setName("second_Album");
        album2.setBackgroundColor("blue");
        album2.setPublic(false);
        album2.getPictures().add(picture2);
        album2.getPictures().add(picture3);

        this.albumService.persistAlbum(album2);

        Album album3 = new Album();
        album3.setName("second_Album");
        album3.setBackgroundColor("blue");
        album3.setPublic(true);
        album3.getPictures().add(picture1);
        album3.getPictures().add(picture3);

        this.albumService.persistAlbum(album3);

        //#####################################
        // Add User to Album

        album.setUser(userById1);
        album2.setUser(userById1);
        album3.setUser(userById2);

        //#####################################
        //Get Users by Email Provider

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("### Enter email provider: ");
        String emailProvider = reader.readLine();

        this.userService.printUsersByEmailProvider(emailProvider);

        //#####################################
        //Remove Inactive Users

        System.out.println("### Enter date in format: 12 Oct 2004");
        String date = reader.readLine();

        this.userService.removeInactiveUsers(date);
    }
}
