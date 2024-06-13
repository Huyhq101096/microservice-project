package com.base.mapper;

import com.base.dto.request.ProfileCreationRequest;
import com.base.dto.request.UserCreationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}
