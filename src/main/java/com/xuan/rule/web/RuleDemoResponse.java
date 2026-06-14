package com.xuan.rule.web;

public class RuleDemoResponse {

    private String engine;
    private double originalPrice;
    private double finalPrice;
    private String level;

    public RuleDemoResponse() {
    }

    public RuleDemoResponse(String engine, double originalPrice, double finalPrice, String level) {
        this.engine = engine;
        this.originalPrice = originalPrice;
        this.finalPrice = finalPrice;
        this.level = level;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
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
