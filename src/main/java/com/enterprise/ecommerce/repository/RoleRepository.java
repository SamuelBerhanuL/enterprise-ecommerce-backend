package com.enterprise.ecommerce.repository;

import com.enterprise.ecommerce.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository → gives us CRUD automatically
public interface RoleRepository extends JpaRepository <Role, Long> {
}
