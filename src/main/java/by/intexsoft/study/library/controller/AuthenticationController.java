package by.intexsoft.study.library.controller;

import by.intexsoft.study.library.api.AuthenticationApi;
import by.intexsoft.study.library.mapper.UserMapper;
import by.intexsoft.study.library.security.JwtTokenProvider;
import by.intexsoft.study.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController implements AuthenticationApi {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    private final UserMapper userMapper;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService, UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.userMapper = userMapper;
    }

}
