package ru.tampashev.databaselayer.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

//@SuppressWarnings(value = "unused")
@Entity(name = "internet_shop.roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(targetEntity = User.class, mappedBy = "role", cascade = CascadeType.MERGE)
    private Set<User> users;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Role)) return false;
        Role role = (Role) other;
        return name.equals(role.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
