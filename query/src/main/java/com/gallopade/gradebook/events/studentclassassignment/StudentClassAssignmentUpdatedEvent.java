package com.gallopade.gradebook.events.studentclassassignment;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class StudentClassAssignmentUpdatedEvent {
    private String id;
    private StudentClassAssignment studentClassAssignment;
    private UserContextJson uctx;
}
