package com.kl.usersystem.domain.entities;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
    private Integer id;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
