package com.xuan.rule.domain;

public class Order {

    private double originalPrice;
    private double finalPrice;
    private String level;

    public Order() {
    }

    public Order(double originalPrice, String level) {
        this.originalPrice = originalPrice;
        this.finalPrice = originalPrice;
        this.level = level;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
