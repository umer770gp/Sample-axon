package com.gallopade.gradebook.events.studentclassassignment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserContextJson {
    private String userId;
    private String userName;
    private String firstName;
    private String lastName;
    private DefaultResponse tenant;
    private List<DefaultResponse> role;
    private List<String> schoolYearIds;
    private String academicSessionId;
    private String vendor;
    private String apiProvider;
    private String permissions;
    private String externalAssignmentId;
    private Long classId;
    private Date startDate;
    private Date endDate;
    private String stateNationalId;
    private String districtId;
    private String orgId;
    private String courseId;
}
