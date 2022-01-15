package com.example.solid.api.order;

import com.example.solid.api.domain.item.*;
import com.example.solid.api.domain.item.categories.Cigar;
import com.example.solid.api.domain.item.categories.Electronic;
import com.example.solid.api.domain.item.categories.Paper;
import com.example.solid.api.domain.item.categories.Water;
import com.example.solid.api.service.ItemService;
import com.example.solid.api.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OrderTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should calculate an order subtotal without texes")
    public void calculateSubtotal() {
        when(itemService.getAllItems()).thenReturn(getMockedItems());

        List<Item> itemList = itemService.getAllItems();

        double subtotal = 0;

        for (Item item : itemList) {
            subtotal += item.getPrice();
        }

        assertEquals(subtotal, 515.0);
    }

    @Test
    @DisplayName("Should return an order subtotal with the item taxes calculated")
    public void calculateSubtotalAndTaxesTest() {
        when(itemService.getAllItems()).thenReturn(getMockedItems());

        orderService.calculateSubTotal();

        List<Item> itemList = itemService.getAllItems();

        double subtotal = 0;

        for (Item item : itemList) {
            subtotal += item.getPrice();
        }

        assertEquals(subtotal, 615.9);
    }

    public List<Item> getMockedItems() {
        return asList(
                new Water(
                        UUID.fromString("4956f8bc-9e94-477c-9d6b-d9cce12fcd85"),
                        "Crystal",
                        "Water",
                        2.0 // 2.1
                ),
                new Cigar(
                        UUID.fromString("a4c8e04c-a4af-4503-a094-6214f7e70696"),
                        "Marlboro",
                        "Cigar",
                        8.0 // 8.8
                ),
                new Electronic(
                        UUID.fromString("2a477431-b21f-46ca-a957-b1c7b83b3203"),
                        "Playstation 5",
                        "Electronic",
                        500 // 600.0
                ),
                new Paper(
                        UUID.fromString("b200cd82-74be-45de-898b-cebbcc42ce98"),
                        "Chamex",
                        "Paper",
                        5.0 // 5.0
                )
        );
    }
}
