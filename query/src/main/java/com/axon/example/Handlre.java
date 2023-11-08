package com.axon.example;

import com.axon.example.dto.ProductCreatedEvent;
import com.gallopade.gradebook.events.studentclassassignment.StudentClassAssignmentUpdatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("order-group")
public class Handlre {

    @QueryHandler
    public Object handleStreaming(FindQuery event) {
        System.out.println("In query handler");
        return null;
    }

    @EventHandler
    public Object handleEvent(ProductCreatedEvent event) {

        System.out.println("Handle event");
        return null;
    }

    @EventHandler
    public Object on(StudentClassAssignmentUpdatedEvent event) {
        System.out.println("event handled");
        return null;
    }
}