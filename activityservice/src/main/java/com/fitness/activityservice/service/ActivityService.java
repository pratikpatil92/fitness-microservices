package com.fitness.activityservice.service;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.dto.ApiResponse;
import com.fitness.activityservice.models.Activity;
import com.fitness.activityservice.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final ModelMapper modelMapper;

    public ActivityResponse trackActivity(ActivityRequest activityRequest) {
        Activity activity = modelMapper.map(activityRequest, Activity.class);
        Activity savedActivity = activityRepository.save(activity);
        return modelMapper.map(savedActivity, ActivityResponse.class);
    }

    public ApiResponse getAllActivities() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setActivityResponses(
                activityRepository.findAll()
                        .stream()
                        .map(activity -> modelMapper.map(activity, ActivityResponse.class))
                        .toList()
        );
        apiResponse.setMessage("All activities retrieved successfully");
        apiResponse.setStatus("SUCCESS");
        return apiResponse;
    }
}
