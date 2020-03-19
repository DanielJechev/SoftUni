package app.domain.entities;

import app.annotations.Password;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    private long id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private Set<Game> games;

    public User() {
        this.role = Role.USER;
    }

    public User(String name) {
        this.name = name;
        this.role = Role.USER;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="email", nullable = false, unique = true)
    @Email(regexp = "^([A-Za-z\\d]+[\\.\\-\\_]*[A-Za-z\\d]+)@([\\w\\d\\.\\_\\-]+(\\.)+[\\w\\d]+)$",
    message = "Invalid email.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false, name = "password")
    @Password(containsDigit = true,
            containsLowerCase = true,
            containsUpperCase = true,
            maxLength = 25)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToMany
    @JoinTable(name="users_games",
    joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="game_id",referencedColumnName = "id"))
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
