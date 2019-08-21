package ru.tampashev.shop.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bin {

    private List<Purchase> purchaseList = new ArrayList<>();

    class Purchase {

        private Product product;
        private Integer quantity;
        private BigDecimal totalCost;

        Purchase(Product product, Integer quantity) {
            this.product = product;
            this.quantity = quantity;
            totalCost = product.getPrice().multiply(new BigDecimal(quantity));
        }

        public Product getProduct() {
            return product;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public BigDecimal getTotalCost() {
            return totalCost;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public void setTotalCost(BigDecimal totalCost) {
            this.totalCost = totalCost;
        }
    }

    public boolean add(Product product, Integer quantity){
        return purchaseList.add(new Purchase(product, quantity));
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }
}
