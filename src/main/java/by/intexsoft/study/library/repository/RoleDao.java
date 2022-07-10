package by.intexsoft.study.library.repository;

import by.intexsoft.study.library.model.Role;

public interface RoleDao extends Dao<Role>{

    Role findByRoleName(String roleName);

}
