package com.base.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.base.dto.request.RoleRequest;
import com.base.dto.response.RoleResponse;
import com.base.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
