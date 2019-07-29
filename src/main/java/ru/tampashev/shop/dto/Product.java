package ru.tampashev.shop.dto;

public class Product {

    private Integer id;
    private String name;
    private Integer price;
    private Category category;
    private Parameters parameters;
    private Integer weight ;
    private Integer volume;
    private Integer quantityInStock;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getVolume() {
        return volume;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
