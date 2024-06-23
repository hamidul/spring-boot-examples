package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.service.MyService;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/get/{param}")
    public String getData(@PathVariable("param") String param) {
        return myService.getData(param);
    }
}