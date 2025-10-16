package com.springbootapi.btvnbuoi34.service;

import com.springbootapi.btvnbuoi34.entity.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
    User saveUsers(@RequestBody User user);
}
