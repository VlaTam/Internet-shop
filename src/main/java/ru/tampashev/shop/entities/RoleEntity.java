package ru.tampashev.shop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

//@SuppressWarnings(value = "unused")
@Entity(name = "internet_shop.roles")
public class RoleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(targetEntity = UserEntity.class, mappedBy = "role", cascade = CascadeType.MERGE)
    private Set<UserEntity> userEntities;

    public RoleEntity() {
    }

    public RoleEntity(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleEntity)) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(userEntities, that.userEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userEntities);
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
