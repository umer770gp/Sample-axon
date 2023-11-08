package com.gallopade.gradebook.events.studentclassassignment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentClassAssignment {

    private String studentClassAssignmentId;
    private String uuid;
    private String classAssignmentId;
    private String classId;
    private String curriculumMapDetailsId;
    private String contentTypeId;
    private String contentLinkId;
    private String userId;
    private String status;
    private Date dateLastModified;
    private String userLastModified;
    private Date startTime;
    private Date startDate;
    private Date endDate;
    private Date endTime;
    private Date submitDateTime;
    private String parentStudentClassAssignmentId;
    private Double weight;
    private Boolean graded;
    private Double finalGrade;
    private Double originalGrade;
    private Boolean releaseGradesToStudents;
    private Boolean studentCanReviewWork;
    private String studentComment;
    private Boolean allowLateSubmission;
    private Integer latePenalty;
    private Date lateDate;
    private Time lateTime;
    private String studentUploadedResourceId;
    private Boolean RandomizeQuestions;
    private Boolean RandomizeAnswers;
    private Double totalPoints;
    private String teacherComment;
    private String studentCanReviewWorkId;
    private Boolean marksProcess;
}
