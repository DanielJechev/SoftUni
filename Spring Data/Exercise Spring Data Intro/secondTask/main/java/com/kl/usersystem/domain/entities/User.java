package com.kl.usersystem.domain.entities;

import com.kl.usersystem.validations.Email;
import com.kl.usersystem.validations.Password;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    private String password;
    private String email;
    private byte[] profile_picture;
    private LocalDateTime registeredOn;
    private LocalDateTime lastTimeLoggedIn;
    private Integer age;
    private Boolean is_deleted;
    private Town birthTown;
    private Town currentlyLivingTown;
    private String firstName;
    private String lastName;
    private String fullName;
    private Set<User> friends;
    private Set<User> people;
//    private Set<Album> albums;

    public User() {
        this.friends = new HashSet<>();
        this.people = new HashSet<>();
//        this.albums = new HashSet<>();
    }

    @Column(name = "username", nullable = false)
    @Size(min = 4, max = 30, message = "Username should be at least 4 and maximum 30 characters long.")
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    @Password(minLength = 6, maxLength = 50, containsDigit = true, containsLowercaseLetter = true, containsSpecialSymbol = true, containsUppercaseLetter = true)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Column(name = "email", nullable = false)
    @Email
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "profile_picture", columnDefinition = "LONGBLOB")
    public byte[] getProfile_picture() {
        return this.profile_picture;
    }

    public void setProfile_picture(byte[] profile_picture) {
//        if(profile_picture.length > 1024 * 1024){
//            throw new IllegalArgumentException("Picture too big!");
//        }
        this.profile_picture = profile_picture;
    }

    @Column(name = "registered_on")
    public LocalDateTime getRegisteredOn() {
        return this.registeredOn;
    }

    public void setRegisteredOn(LocalDateTime registeredOn) {
        this.registeredOn = registeredOn;
    }

    @Column(name = "last_time_loggedIn")
    public LocalDateTime getLastTimeLoggedIn() {
        return this.lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(LocalDateTime lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    @Column(name = "age")
    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        if (age < 1 || age > 120) {
            throw new IllegalArgumentException("Age should be between 1 and 120.");
        }

        this.age = age;
    }

    @Column(name = "is_deleted", columnDefinition = "BOOLEAN DEFAULT FALSE")
    public Boolean getIs_deleted() {
        return this.is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    @OneToOne(targetEntity = Town.class)
    @JoinColumn(name = "born_town_id", referencedColumnName = "id")
    public Town getBirthTown() {
        return this.birthTown;
    }

    public void setBirthTown(Town birthTown) {
        this.birthTown = birthTown;
    }

    @OneToOne(targetEntity = Town.class)
    @JoinColumn(name = "current_town_id", referencedColumnName = "id")
    public Town getCurrentlyLivingTown() {
        return this.currentlyLivingTown;
    }

    public void setCurrentlyLivingTown(Town currentlyLivingTown) {
        this.currentlyLivingTown = currentlyLivingTown;
    }


    @Column(name = "first_name")
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "friends_peoples",
            joinColumns = @JoinColumn(name = "friend_id"),
            inverseJoinColumns = @JoinColumn(name = "people_id"))
    public Set<User> getFriends() {
        return this.friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @ManyToMany(mappedBy = "friends")
    public Set<User> getPeople() {
        return this.people;
    }

    public void setPeople(Set<User> people) {
        this.people = people;
    }

//    @OneToMany(targetEntity = Album.class, mappedBy = "user")
//    public Set<Album> getAlbums() {
//        return this.albums;
//    }
//
//    public void setAlbums(Set<Album> albums) {
//        this.albums = albums;
//    }

    @Transient
    public String getFullName() {
        return this.firstName + ' ' + this.lastName;
    }


}
