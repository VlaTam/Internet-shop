package ru.tampashev.shop.exceptions;

public class UserAlreadyExistException extends ObjectAlreadyExistException {

    public UserAlreadyExistException() {
    }

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
