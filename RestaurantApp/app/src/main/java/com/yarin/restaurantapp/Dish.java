package com.yarin.restaurantapp;

import androidx.annotation.NonNull;

public class Dish {

    private final String title, description;
    private final int price;

    public Dish(final String title, final String description, final int price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @NonNull
    @Override
    public String toString() {
        return title;
    }
}
