package by.intexsoft.study.library.controller;

import by.intexsoft.study.library.api.UsersApi;
import by.intexsoft.study.library.model.UserDto;
import by.intexsoft.study.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UsersApi {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Void> createUser(UserDto userDto) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserDto>> findAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @Override
    public ResponseEntity<Void> patchUser(UserDto userDto) {
        return  new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateUser(UserDto userDto) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
