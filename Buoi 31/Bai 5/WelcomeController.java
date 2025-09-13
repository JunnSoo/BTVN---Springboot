package com.cybersoft.demospringboot10.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {
    @GetMapping("/{username}")
    public String welcome(@PathVariable String username, @RequestParam String lang)
    {
        if(lang.equals("en")) return "Hello "+username;
        else return "Xin Chao "+username;
    }
}
