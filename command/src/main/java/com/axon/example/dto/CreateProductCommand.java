package com.axon.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductCommand {
    @TargetAggregateIdentifier
    private String id;
    private String barcode;
    private String title;
    private String brand;
    private String category;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
