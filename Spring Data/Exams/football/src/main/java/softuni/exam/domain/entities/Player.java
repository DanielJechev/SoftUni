package softuni.exam.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "players")
public class Player extends BaseEntity{
    /*
    •	id – integer number, primary identification field.
•	first_name – a string (required).
•	last_name – a string (required) between 3 and 15 characters.
•	number – a Integer (required) between 1 and 99.
•	salary – a Bigdecimal (required) min 0.
•	position – an ENUM (required).
•	picture – a Picture entity (required).
•	team – a Team entity (required).

     */

    private String firstName;
    private String lastName;
    private Integer number;
    private BigDecimal salary;
    private Position position;
    private Picture picture;
    private Team team;

    public Player() {
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Column(name = "salary", nullable = false)
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Enumerated(EnumType.STRING)
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
