package com.axon.example.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@Builder
public class ProductCreatedEvent {
    private String id;
    private String barcode;
    private String title;
    private String brand;
    private String category;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
