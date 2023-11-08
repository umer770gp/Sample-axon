package com.axon.example;

import com.axon.example.dto.ProductUpdateEvent;
import com.axon.example.dto.UpdateProductCommand;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.axon.example.dto.CreateProductCommand;
import com.axon.example.dto.ProductCreatedEvent;

import java.math.BigDecimal;
import java.util.UUID;

@Aggregate
@NoArgsConstructor
public class ProductAggregate {
    @AggregateIdentifier
    private String id;
    private String barcode;
    private String title;
    private String brand;
    private String category;
    private String description;
    private BigDecimal price;
    private Integer quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {
        ProductCreatedEvent productCreatedEvent = ProductCreatedEvent.builder()
                .id(createProductCommand.getId())
                .description(createProductCommand.getDescription())
                .title(createProductCommand.getTitle())
                .barcode(createProductCommand.getBarcode())
                .category(createProductCommand.getCategory())
                .quantity(createProductCommand.getQuantity())
                .build();
        AggregateLifecycle.apply(productCreatedEvent);
    }

    @CommandHandler
    void on(UpdateProductCommand updateProductCommand) {
        ProductUpdateEvent productUpdateEvent = ProductUpdateEvent.builder()
                .id(updateProductCommand.getId())
                .description(updateProductCommand.getDescription())
                .title(updateProductCommand.getTitle())
                .barcode(updateProductCommand.getBarcode())
                .category(updateProductCommand.getCategory())
                .quantity(updateProductCommand.getQuantity()).build();
        AggregateLifecycle.apply(productUpdateEvent);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        System.out.println("eventSourcing handler Create -> " + productCreatedEvent.toString());
        this.id = productCreatedEvent.getId();
        this.quantity = productCreatedEvent.getQuantity();
        this.barcode = productCreatedEvent.getBarcode();
        this.title = productCreatedEvent.getTitle();
        this.category = productCreatedEvent.getCategory();
        this.description = productCreatedEvent.getDescription();
    }

    @EventSourcingHandler
    public void on(ProductUpdateEvent productUpdateEvent) {
        System.out.println("eventSourcing handler update -> " +productUpdateEvent.toString());
        this.quantity = productUpdateEvent.getQuantity();
        this.barcode = productUpdateEvent.getBarcode();
        this.title = productUpdateEvent.getTitle();
        this.category = productUpdateEvent.getCategory();
        this.description = productUpdateEvent.getDescription();
    }
}
