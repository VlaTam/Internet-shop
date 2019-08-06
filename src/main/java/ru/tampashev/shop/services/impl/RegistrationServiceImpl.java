package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.dto.Address;
import ru.tampashev.shop.dto.RegistrationForm;
import ru.tampashev.shop.dto.Role;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.services.AddressService;
import ru.tampashev.shop.services.RegistrationService;
import ru.tampashev.shop.services.RoleService;
import ru.tampashev.shop.services.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private RoleService roleService;

    private final String roleName = "customer";

    public boolean doRegistration(RegistrationForm registrationForm) {
        Address address = createAddressWithId(registrationForm);
        try {
            User user = createUser(registrationForm, address);
            if (!isExistedUser(user)) {
                userService.create(user);
                return true;
            }
        } catch (ParseException ignore) { //TODO: make correct behavior

        }
        return false;
    }

    private Address createAddressWithId(RegistrationForm registrationForm) {
        Address address = createAddress(registrationForm);
        Address addressInDatabase = isExistedAddress(address);

        if (addressInDatabase == null) {
            Integer addressId = addressService.create(address);
            address.setId(addressId);
        } else address = addressInDatabase;

        return address;
    }

    private Address createAddress(RegistrationForm registrationForm){
        Address address = new Address();
        address.setCountry(registrationForm.getCountry());
        address.setCity(registrationForm.getCity());
        address.setStreet(registrationForm.getStreet());
        address.setPostalCode(registrationForm.getPostalCode());
        address.setHouseNumber(registrationForm.getHouseNumber());
        address.setFlatNumber(registrationForm.getFlatNumber());
        return address;
    }

    private Address isExistedAddress(Address address){
        List<Address> addresses = (List<Address>)addressService.findAll();
        int positionInList = addresses.indexOf(address);

        if (positionInList >= 0)
            return addresses.get(positionInList);

        return null;
    }

    private User createUser(RegistrationForm registrationForm, Address address) throws ParseException {
        User user = new User();
        user.setAddress(address);

        user.setMailAddress(registrationForm.getMailAddress());
        user.setPassword(registrationForm.getPassword());
        user.setLastName(registrationForm.getLastName());
        user.setFirstName(registrationForm.getFirstName());

        Date birthday = convertToDate(registrationForm.getBirthday());
        user.setBirthday(birthday);

        Role role = roleService.findByName(roleName);
        user.setRole(role);
        return user;
    }

    private Date convertToDate(String stringDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(stringDate);
    }

    private boolean isExistedUser(User user){
        User existUser = userService.findByMailAddress(user.getMailAddress());
        return existUser != null;
    }
}
