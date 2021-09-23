package com.peaksoft.service;


import com.peaksoft.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    List<String> getRoleNamesToList();
    Role getRoleByName(String name);
}
