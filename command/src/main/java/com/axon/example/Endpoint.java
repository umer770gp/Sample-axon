package com.axon.example;

import com.axon.example.dto.UpdateProductCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axon.example.dto.CreateProductCommand;

import java.util.UUID;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/products")
public class Endpoint {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public ResponseEntity<String> createProduct() {
        String id = UUID.randomUUID().toString();
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .id(id)
                .quantity(5)
                .title("umer")
                .build();
        commandGateway.sendAndWait(createProductCommand);

        for (int i = 0; i < 2; i++) {
            UpdateProductCommand updateProductCommand = UpdateProductCommand.builder()
                    .id(id)
                    .quantity(i)
                    .title("umer1")
                    .build();
            commandGateway.sendAndWait(updateProductCommand);
        }

        UpdateProductCommand updateProductCommand = UpdateProductCommand.builder()
                .id(id)
                .quantity(2)
                .title("umer1")
                .barcode("umer the pawa")
                .build();
        commandGateway.sendAndWait(updateProductCommand);
        return ResponseEntity.ok((String) "helloo");
    }


}
