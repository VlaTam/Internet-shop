package ru.tampashev.shop.converters;

import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.Role;
import ru.tampashev.shop.entities.RoleEntity;

@Component
public class RoleConverter implements Converter<RoleEntity, Role> {

    @Override
    public Role convertToDto(RoleEntity roleEntity) {
        Role role = new Role();
        role.setId(roleEntity.getId());
        role.setName(roleEntity.getName());
        return role;
    }

    @Override
    public RoleEntity convertToEntity(Role role) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(role.getId());
        roleEntity.setName(role.getName());
        return roleEntity;
    }
}
