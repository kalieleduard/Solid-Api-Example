package com.example.solid.api.domain.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public abstract class Item {

    @Id
    @Column(name = "id")
    @JsonProperty(value = "id")
    private UUID id;

    @Column(name = "item_name")
    @JsonProperty(value = "itemName")
    private String itemName;

    @Column(name = "category")
    @JsonProperty(value = "category")
    private String category;

    @Column(name = "price")
    @JsonProperty(value = "price")
    private double price;
}
