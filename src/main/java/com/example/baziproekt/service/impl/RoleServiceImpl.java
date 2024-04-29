package com.example.baziproekt.service.impl;

import com.example.baziproekt.model.Role;
import com.example.baziproekt.repository.RoleRepository;
import com.example.baziproekt.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public List<Role> listAll() {
        return roleRepository.findAll();
    }
}
