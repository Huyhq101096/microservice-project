package com.project.profile.service;

import com.project.profile.dto.request.ProfileCreationRequest;
import com.project.profile.dto.response.UserProfileResponse;
import com.project.profile.entity.UserProfile;
import com.project.profile.mapper.UserProfileMapper;
import com.project.profile.repository.UserProfileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileService {


    UserProfileRepository userProfileRepository;
    private final UserProfileMapper userProfileMapper;


    public UserProfileResponse createProfile(ProfileCreationRequest request) {
        UserProfile userProfile = userProfileMapper.toUserProfile(request);

        userProfile = userProfileRepository.save(userProfile);

        return userProfileMapper.toUserProfileResponse(userProfile);

    }

    public UserProfileResponse getProfile(String id) {

        UserProfile userProfile = userProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));

        return userProfileMapper.toUserProfileResponse(userProfile);
    }



}
