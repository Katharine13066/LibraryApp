package by.intexsoft.study.library.security;

import by.intexsoft.study.library.mapper.UserMapper;
import by.intexsoft.study.library.model.User;
import by.intexsoft.study.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    @Qualifier("userService")
    private final UserService userService;

    @Autowired
    private final UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public JwtUserDetailsService(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.fromDto(userService.findByUserName(username));

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);

        JwtUser jwtUser = JwtUserFactory.create(user);
        return jwtUser;
    }
}