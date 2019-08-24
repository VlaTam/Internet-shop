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
import java.util.Set;
import java.util.stream.Collectors;

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
        BigDecimal totalPrice = new BigDecimal("0");

        if (purchaseSet == null) {
            purchaseSet = new HashSet<>();
        } else {
            totalPrice = new BigDecimal((String) session.getAttribute("totalPrice"));
        }

        Integer productId = Integer.parseInt(request.getParameter("productId"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));

        Product product = productService.findById(productId);
        Purchase purchase = new Purchase(product, quantity);

        BigDecimal purchasePrice = product.getPrice().multiply(new BigDecimal(quantity));
        totalPrice = totalPrice.add(purchasePrice);

        purchaseSet.remove(purchase);
        purchaseSet.add(purchase);

        session.setAttribute("purchaseSet", purchaseSet);
        session.setAttribute("totalPrice", totalPrice);
        return true;
    }

    @Override
    public boolean delete(Product product) {
        HashSet<Purchase> purchaseSet = (HashSet<Purchase>) session.getAttribute("purchaseSet");
        Integer quantityOfProducts = getQuantityOfProducts(purchaseSet);

        Purchase purchase = new Purchase();
        purchase.setProduct(product);

        boolean result = purchaseSet.remove(purchase);
        session.setAttribute("purchaseSet", purchaseSet);

        Integer quantityOfDeletedProduct = quantityOfProducts - getQuantityOfProducts(purchaseSet);
        BigDecimal totalPrice = new BigDecimal((String) session.getAttribute("totalPrice"));
        totalPrice = totalPrice.subtract(product.getPrice().multiply(new BigDecimal(quantityOfDeletedProduct)));
        session.setAttribute("totalPrice", totalPrice);

        return result;
    }

    private Integer getQuantityOfProducts(Set<Purchase> bin){
        Integer quantity = 0;
        for (Purchase purchase : bin){
            quantity += purchase.getQuantity();
        }
        return quantity;
    }
}
