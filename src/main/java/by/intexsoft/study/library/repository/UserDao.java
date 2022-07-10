package by.intexsoft.study.library.repository;

import by.intexsoft.study.library.model.User;

public interface UserDao extends Dao<User>{

    User findByEmail(String email);

    User findByUserName(String userName);
}
