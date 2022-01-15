package com.example.solid.api.domain.item.categories;

import com.example.solid.api.domain.item.TaxesItem;

import java.util.UUID;

public class Electronic extends TaxesItem {

    public Electronic(UUID id, String itemName, String category, double price) {
        super(id, itemName, category, price);
    }

    @Override
    public void calculateTaxes() {
        setPrice(getPrice() + getPrice() * 0.2);
    }
}
