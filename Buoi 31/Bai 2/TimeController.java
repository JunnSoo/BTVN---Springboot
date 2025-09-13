package com.cybersoft.demospringboot10.controller;

import com.cybersoft.demospringboot10.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {
    private final TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService){
        this.timeService = timeService;
    }

    @GetMapping("/time")
    public String getTime(){
        return timeService.getCurrentTime();
    }
}
