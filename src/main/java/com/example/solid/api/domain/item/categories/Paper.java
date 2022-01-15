package com.example.solid.api.domain.item.categories;

import com.example.solid.api.domain.item.Item;

import java.util.UUID;

public class Paper extends Item {
    public Paper(UUID id, String itemName, String category, double price) {
        super(id, itemName, category, price);
    }
}
