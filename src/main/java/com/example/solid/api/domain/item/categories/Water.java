package com.example.solid.api.domain.item.categories;

import com.example.solid.api.domain.item.TaxesItem;

import java.util.UUID;

public class Water extends TaxesItem {

    public Water(UUID id, String itemName, String category, double price) {
        super(id, itemName, category, price);
    }

    @Override
    public void calculateTaxes() {
        setPrice(getPrice() + getPrice() * 0.05);
    }
}
