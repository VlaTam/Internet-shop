package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.dto.Purchase;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.services.BasketService;
import ru.tampashev.shop.services.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
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
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Product product = productService.findById(productId);
        Purchase purchase = new Purchase(product, quantity);

        purchaseSet.remove(purchase);
        boolean result = purchaseSet.add(purchase);

        session.setAttribute("purchaseSet", purchaseSet);
        session.setAttribute("totalPrice", getTotalPrice());
        return result;
    }

    @Override
    public boolean delete(Product product) {
        HashSet<Purchase> purchaseSet = (HashSet<Purchase>) session.getAttribute("purchaseSet");

        Purchase purchase = new Purchase();
        purchase.setProduct(product);

        boolean result = purchaseSet.remove(purchase);
        session.setAttribute("purchaseSet", purchaseSet);

        session.setAttribute("totalPrice", getTotalPrice());
        return result;
    }

    private BigDecimal getTotalPrice(){
        BigDecimal totalPrice = new BigDecimal(0);
        HashSet<Purchase> purchaseSet = (HashSet<Purchase>) session.getAttribute("purchaseSet");
        for (Purchase purchase : purchaseSet){
            totalPrice = totalPrice.add(purchase.getTotalCost());
        }
        return totalPrice;
    }
}
