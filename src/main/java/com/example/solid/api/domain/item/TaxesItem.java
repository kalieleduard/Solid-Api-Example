package com.example.solid.api.domain.item;

import java.util.UUID;

public abstract class TaxesItem extends Item {

    public TaxesItem(UUID id, String itemName, String category, double price) {
        super(id, itemName, category, price);
    }

    public abstract void calculateTaxes();
}
