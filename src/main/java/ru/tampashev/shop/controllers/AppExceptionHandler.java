package ru.tampashev.shop.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.tampashev.shop.exceptions.ObjectAlreadyExistException;

@ControllerAdvice(assignableTypes = {UserController.class})
public class AppExceptionHandler {

    @ExceptionHandler(ObjectAlreadyExistException.class)
    public String handConverterException(ObjectAlreadyExistException exception){
        return "/errors/error";
    }
}
