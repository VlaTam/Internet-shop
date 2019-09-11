package ru.tampashev.shop.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class User {

    private Integer id;
    @NotBlank(message = "last name is empty")
    private String lastName;
    @NotBlank(message = "first name is empty")
    private String firstName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NotBlank(message = "email is empty")
    @Size(min = 10, max = 60, message = "length of email is between 10 and 60 symbols")
    private String mailAddress;

    @NotBlank(message = "password is empty")
    @Size(min = 4, max = 12, message = "length of password is between 4 and 12 symbols")
    private String password;

    @NotBlank(message = "confirmation is empty")
    @Size(min = 4, max = 12, message = "length of confirmation is between 4 and 12 symbols")
    private String confirmation;

    @NotNull(message = "choose role")
    private Role role;

    @NotNull(message = "choose address")
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
