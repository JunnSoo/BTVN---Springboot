package com.springbootapi.btvnbuoi34.service.imp;

import com.springbootapi.btvnbuoi34.entity.User;
import com.springbootapi.btvnbuoi34.repository.UserRepository;
import com.springbootapi.btvnbuoi34.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUsers(User user) {
        return userRepository.save(user);
    }
}
