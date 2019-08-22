package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.dto.Purchase;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.services.BasketService;
import ru.tampashev.shop.services.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

@Service
//@SuppressWarnings("all")
public class BasketServiceImpl implements BasketService {

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ProductService productService;

    @Override
    public boolean add() {
        HashSet<Purchase> purchaseSet = (HashSet<Purchase>) session.getAttribute("purchaseSet");

        if (purchaseSet == null) {
            purchaseSet = new HashSet<>();
        }
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));

        Product product = productService.findById(productId);
        Purchase purchase = new Purchase(product, quantity);

        purchaseSet.remove(purchase);
        purchaseSet.add(purchase);

        session.setAttribute("purchaseSet", purchaseSet);
        return true;
    }

    @Override
    public boolean delete(Product product) {
        HashSet<Purchase> purchaseSet = (HashSet<Purchase>) session.getAttribute("purchaseSet");

        Purchase purchase = new Purchase();
        purchase.setProduct(product);
        boolean result = purchaseSet.remove(purchase);

        session.setAttribute("purchaseSet", purchaseSet);
        return result;
    }
}
