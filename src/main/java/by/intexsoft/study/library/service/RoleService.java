package by.intexsoft.study.library.service;

import by.intexsoft.study.library.model.RoleDto;

public interface RoleService {

    RoleDto findByRoleName(String roleName);

}
