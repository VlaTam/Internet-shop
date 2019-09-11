package ru.tampashev.shop.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.tampashev.shop.exceptions.ObjectAlreadyExistException;
import ru.tampashev.shop.exceptions.UserAlreadyExistException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice//(assignableTypes = {UserController.class, OrderController.class})
public class AppExceptionHandler {

/*    @ExceptionHandler(value = Exception.class)
    public ModelAndView handConverterException(Exception exception, HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("errors/common-exp");
        return mav;
    }*/
}
