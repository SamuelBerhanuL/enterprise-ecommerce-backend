package com.enterprise.ecommerce.controller;

import com.enterprise.ecommerce.entity.Role;
import com.enterprise.ecommerce.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//POST /api/roles
//GET /api/roles

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

    @GetMapping
    public List<Role> getRoles(){
        return roleService.getAllRoles();
    }
}
