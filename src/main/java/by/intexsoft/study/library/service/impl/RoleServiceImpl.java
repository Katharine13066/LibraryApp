package by.intexsoft.study.library.service.impl;

import by.intexsoft.study.library.mapper.RoleMapper;
import by.intexsoft.study.library.model.RoleDto;
import by.intexsoft.study.library.repository.RoleDao;
import by.intexsoft.study.library.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleMapper roleMapper;

    public RoleServiceImpl(RoleDao roleDao, RoleMapper roleMapper) {
        this.roleDao = roleDao;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleDto findByRoleName(String roleName) {
        return roleMapper.toDto(roleDao.findByRoleName(roleName));
    }
}