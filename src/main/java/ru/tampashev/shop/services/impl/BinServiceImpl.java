package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.dto.Bin;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.services.BinService;
import ru.tampashev.shop.services.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class BinServiceImpl implements BinService {

    @Autowired
    private ProductService productService;

    @Override
    public boolean add(HttpSession session, HttpServletRequest request) {
        Bin bin = (Bin)session.getAttribute("bin");
        if (bin == null) {
            bin = new Bin();
        }
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));

        Product product = productService.findById(productId);
        bin.add(product, quantity);

        session.setAttribute("bin", bin);
        return true;
    }
}
