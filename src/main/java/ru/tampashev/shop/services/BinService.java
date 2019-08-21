package ru.tampashev.shop.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface BinService {

    //boolean add(Integer productId, Integer quantity);
    boolean add(HttpSession session, HttpServletRequest request);
}
