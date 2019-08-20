package ru.tampashev.shop.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import ru.tampashev.shop.exceptions.ObjectAlreadyExistException;
import ru.tampashev.shop.exceptions.UserAlreadyExistException;

@ControllerAdvice(assignableTypes = {UserController.class})
public class AppExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handConverterException(ObjectAlreadyExistException exception, Model model){

        return "/errors/error";
    }
}
