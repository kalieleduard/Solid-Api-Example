package com.example.solid.api.service;

import com.example.solid.api.domain.item.Item;
import com.example.solid.api.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public void saveNewItem(Item item) {
        itemRepository.save(item);
    }

    public Item findById(UUID id) {
        return itemRepository.getById(id);
    }
}
