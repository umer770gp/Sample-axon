package com.axon.example.dto;

import lombok.Builder;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Getter
@Builder()
public class UpdateProductCommand {
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
