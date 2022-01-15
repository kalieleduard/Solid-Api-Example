package com.example.solid.api.item;

import com.example.solid.api.domain.item.Item;
import com.example.solid.api.domain.item.TaxesItem;
import com.example.solid.api.domain.item.categories.Water;
import com.example.solid.api.repository.ItemRepository;
import com.example.solid.api.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ItemTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should calculate the individual item taxes")
    public void calculateTaxes() {
        when(itemRepository.getById(any(UUID.class))).thenReturn(
                new Water(UUID.fromString("c516461a-cd16-4b07-8912-091ba5292938"),
                        "Floresta",
                        "Water",
                        1.0
                )
        );

        Item item = itemService.findById(UUID.fromString("c516461a-cd16-4b07-8912-091ba5292938"));

        if (item instanceof TaxesItem)
            ((TaxesItem) item).calculateTaxes();

        assertEquals(item.getClass(), Water.class);
        assertEquals(item.getPrice(), 1.05);
    }
}
