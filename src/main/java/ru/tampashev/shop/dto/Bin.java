package ru.tampashev.shop.dto;

import java.math.BigDecimal;
import java.util.List;

public class Bin {

    private List<Purchase> purchaseList;

    class Purchase {

        private Product product;
        private Integer quantity;
        private BigDecimal totalCost;

        public Purchase(Product product, Integer quantity) {
            this.product = product;
            this.quantity = quantity;
            totalCost = product.getPrice().multiply(new BigDecimal(quantity));
        }
    }

    public boolean add(Product product, Integer quantity){
        return purchaseList.add(new Purchase(product, quantity));
    }
}
