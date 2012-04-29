package com.fancyworld;

public class Commodity {
    private int count;
    private String name;
    private double price;
    private Type type;
    private String description;

    public Commodity(int count, String name, double price, Type type, String description) {
        this.count = count;
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
