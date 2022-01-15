package com.example.solid.api.service;

import com.example.solid.api.domain.item.Item;
import com.example.solid.api.domain.item.TaxesItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ItemService itemService;

    public void calculateSubTotal() {
        List<Item> itemList = itemService.getAllItems();
        itemList.forEach(item -> {
            if (item instanceof TaxesItem) {
                ((TaxesItem) item).calculateTaxes();
            }
        });
    }
}
