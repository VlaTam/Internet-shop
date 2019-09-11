package ru.tampashev.shop.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Objects;

public class Address {

    private Integer id;

    @NotBlank(message = "country is empty")
    private String country;

    @NotBlank(message = "city is empty")
    private String city;

    @NotBlank(message = "postal code is empty")
    private String postalCode;

    @NotBlank(message = "street is empty")
    private String street;

    @NotNull(message = "type house number")
    @Min(value = 1, message = "house number: min value is 1")
    @Max(value = 500, message = "house number: max value is 500")
    private Integer houseNumber;

    @NotNull(message = "type flat number")
    @Min(value = 1, message = "flat number: min value is 1")
    @Max(value = 2000, message = "flat number: max value is 2000")
    private Integer flatNumber;

    private Collection<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) &&
                Objects.equals(city, address.city) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(street, address.street) &&
                Objects.equals(houseNumber, address.houseNumber) &&
                Objects.equals(flatNumber, address.flatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, postalCode, street, houseNumber, flatNumber);
    }

    public Integer getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreet() {
        return street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
