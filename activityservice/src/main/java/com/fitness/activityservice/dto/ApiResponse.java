package com.fitness.activityservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {
    private List<ActivityResponse> activityResponses;
    private String message;
    private String status;
}
