package com.example.solid.api.controller;

import com.example.solid.api.domain.item.Item;
import com.example.solid.api.domain.item.TaxesItem;
import com.example.solid.api.repository.ItemRepository;
import com.example.solid.api.service.ItemService;
import com.example.solid.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/solid-api")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> itemList = itemService.getAllItems();
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    @GetMapping("/get-all-with-taxes")
    public ResponseEntity<List<Item>> getAllItemsWithTaxesCalculated() {
        List<Item> itemList = itemService.getAllItems();

        itemList.forEach(item -> {
            if (item instanceof TaxesItem)
                ((TaxesItem) item).calculateTaxes();
        });

        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    @PostMapping("/save-item")
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        itemService.saveNewItem(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }
}
