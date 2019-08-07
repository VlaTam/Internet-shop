package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.transfer.ResponseTransfer;

public interface UserService extends GenericService<User> {

    User findByMailAddress(String mailAddress);

    ResponseTransfer authorize(User user);
}
