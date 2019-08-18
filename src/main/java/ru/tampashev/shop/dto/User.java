package ru.tampashev.shop.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class User {

    private Integer id;
    private String lastName;
    private String firstName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String mailAddress;
    private String password;
    private String confirmation;
    private Role role;// = new Role();
    private Address address;
    private List<Order> orders;

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

    public Address getAddress() {
        return address;
    }

    public List<Order> getOrders() {
        return orders;
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

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }
}
