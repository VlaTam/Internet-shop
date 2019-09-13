package ru.tampashev.shop.controllers;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AppExceptionHandler {

    private static final Logger logger = Logger.getLogger(AppExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handConverterException(Exception exception, HttpServletRequest req){
        logger.error("--->" + exception.getMessage());
        exception.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("errors/common-exp");
        return mav;
    }
}
