package ru.tampashev.databaselayer.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@SuppressWarnings(value = "unused")
@Entity(name = "internet_shop.user")
public abstract class User implements Serializable {

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
    @JoinColumn(name = "role.id", nullable = false)
    private Role role;

    public User() {
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof User)) return false;
        User user = (User) other;
        return mailAddress.equals(user.mailAddress) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return mailAddress.hashCode() + password.hashCode();
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

    public Role getRole() {
        return role;
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

    public void setRole(Role role) {
        this.role = role;
    }
}
