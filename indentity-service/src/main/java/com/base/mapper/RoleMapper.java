package com.base.mapper;

import com.base.dto.request.PermissionRequest;
import com.base.dto.request.RoleRequest;
import com.base.dto.response.PermissionResponse;
import com.base.dto.response.RoleResponse;
import com.base.entity.Permission;
import com.base.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);

}
