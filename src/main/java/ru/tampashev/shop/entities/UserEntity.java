package ru.tampashev.shop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user", schema = "internet_shop")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity roleEntity;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity addressEntity;

    //TODO add order collection


    public UserEntity() {
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

    public AddressEntity getAddressEntity() {
        return addressEntity;
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

    public void setRoleEntity(RoleEntity role) {
        this.roleEntity = role;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }
}