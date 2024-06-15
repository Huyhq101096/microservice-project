package com.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}
