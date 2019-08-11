package ru.tampashev.shop.exceptions;

public class ObjectAlreadyExistException extends Exception {

    public ObjectAlreadyExistException() {
    }

    public ObjectAlreadyExistException(String message) {
        super(message);
    }
}
