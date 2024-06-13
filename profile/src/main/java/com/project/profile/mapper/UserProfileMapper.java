package com.project.profile.mapper;

import com.project.profile.dto.request.ProfileCreationRequest;
import com.project.profile.dto.response.UserProfileResponse;
import com.project.profile.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileResponse(UserProfile userProfile);
}
