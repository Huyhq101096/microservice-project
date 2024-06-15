package com.base.mapper;

import org.mapstruct.Mapper;

import com.base.dto.request.ProfileCreationRequest;
import com.base.dto.request.UserCreationRequest;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}
