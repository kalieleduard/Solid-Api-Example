package com.example.solid.api.domain.order;

import com.example.solid.api.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Order {
    private UUID id;
    private List<Item> items;
}
