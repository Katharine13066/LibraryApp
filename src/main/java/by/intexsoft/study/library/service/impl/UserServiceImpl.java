package by.intexsoft.study.library.service.impl;

import by.intexsoft.study.library.mapper.RoleMapper;
import by.intexsoft.study.library.mapper.UserMapper;
import by.intexsoft.study.library.model.UserDto;
import by.intexsoft.study.library.repository.RoleDao;
import by.intexsoft.study.library.repository.UserDao;
import by.intexsoft.study.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao, UserMapper userMapper, RoleMapper roleMapper) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.toDto(userDao.findById(id));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDtos(userDao.findAll());
    }

    @Override
    @Transactional
    public void deleteAll() {
        userDao.deleteAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    @Transactional
    public UserDto create(UserDto userDto) {
        return userMapper.toDto(userDao.createEntity(userMapper.fromDto(userDto)));
    }

    @Override
    @Transactional
    public UserDto update(UserDto userDto) {
        return userMapper.toDto(userDao.updateEntity(userMapper.fromDto(userDto)));
    }

    @Override
    @Transactional
    public void patch(UserDto userDto) {
        userMapper.updateUserFromDto(userDto, userDao.findById(userDto.getId()));
    }

    @Override
    public UserDto findByEmail(String email) {
        return userMapper.toDto(userDao.findByEmail(email));
    }

    @Override
    public UserDto findByUserName(String userName) {
        return userMapper.toDto(userDao.findByUserName(userName));
    }
}