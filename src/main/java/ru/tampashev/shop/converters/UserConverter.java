package ru.tampashev.shop.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.Address;
import ru.tampashev.shop.dto.Role;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.entities.AddressEntity;
import ru.tampashev.shop.entities.RoleEntity;
import ru.tampashev.shop.entities.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
@SuppressWarnings("all")
public class UserConverter implements Converter<UserEntity, User> {

    @Autowired
    @Qualifier("roleConverter")
    private Converter<RoleEntity, Role> roleConverter;

    @Autowired
    @Qualifier("addressConverter")
    private Converter<AddressEntity, Address> addressConverter;

    @Override
    public User convertToDto(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setBirthday(userEntity.getBirthday());
        user.setMailAddress(userEntity.getMailAddress());
        user.setPassword(userEntity.getPassword());

        Role role = roleConverter.convertToDto(userEntity.getRoleEntity());
        user.setRole(role);

        Address address = addressConverter.convertToDto(userEntity.getAddressEntity());
        user.setAddress(address);

        return user;
    }

    @Override
    public UserEntity convertToEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setBirthday(user.getBirthday());
        userEntity.setMailAddress(user.getMailAddress());
        userEntity.setPassword(user.getPassword());

        RoleEntity roleEntity = roleConverter.convertToEntity(user.getRole());
        userEntity.setRoleEntity(roleEntity);

        AddressEntity addressEntity = addressConverter.convertToEntity(user.getAddress());
        userEntity.setAddressEntity(addressEntity);
        return userEntity;
    }

    @Override
    public List<User> convertToDtoList(List<UserEntity> userEntityList) {
        return userEntityList.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
