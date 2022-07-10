package by.intexsoft.study.library.service;

import by.intexsoft.study.library.model.UserDto;

public interface UserService extends LibraryService<UserDto>{

    UserDto findByEmail(String email);

    UserDto findByUserName(String userName);

}
