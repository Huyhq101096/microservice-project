package com.base.mapper;

import com.base.dto.request.PermissionRequest;
import com.base.dto.response.PermissionResponse;
import com.base.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
