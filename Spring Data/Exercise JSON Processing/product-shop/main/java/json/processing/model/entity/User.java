package json.processing.model.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Set<User> friends;
    private Set<Product> sellingProducts;
    private Set<Product> boughtProducts;

    public User() {
        this.friends = new HashSet<>();
        this.sellingProducts = new HashSet<>();
        this.boughtProducts = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Required
    @Length(min = 3)
    @Column(nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    public Set<Product> getSellingProducts() {
        return sellingProducts;
    }

    public void setSellingProducts(Set<Product> sellingProducts) {
        this.sellingProducts = sellingProducts;
    }

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    public Set<Product> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(Set<Product> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }
}
