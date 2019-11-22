package com.springboot.demo.transactional.controller;

import com.springboot.demo.transactional.service.ITransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trans")
public class TransController {
    @Autowired
    private ITransService transService;

    @RequestMapping("/hello")
    public String hello() {
        transService.hello();
        return "success";
    }
}
