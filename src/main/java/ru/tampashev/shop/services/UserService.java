package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.User;

public interface UserService extends GenericService<User> {

    User findByEmail(String email);
}
