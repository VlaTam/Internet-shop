package ru.tampashev.databaselayer.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//@SuppressWarnings(value = "unused")
@Entity(name = "internet_shop.user")
public abstract class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(nullable = false)
    private Date birthday;

    @Column(name = "mail_address", nullable = false, unique = true)
    private String mailAddress;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "roleEntity.id", nullable = false)
    private RoleEntity roleEntity;

    public UserEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(mailAddress, that.mailAddress) &&
                Objects.equals(password, that.password) &&
                Objects.equals(roleEntity, that.roleEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, birthday, mailAddress, password, roleEntity);
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getPassword() {
        return password;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }
}
