package com.rahulmisra.firebaseexample;

public class Customer {
    private int image;

    public Customer(int image, String name, String city) {
        this.image = image;
        this.name = name;
        this.city = city;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    private String name;
    private String city;
}
