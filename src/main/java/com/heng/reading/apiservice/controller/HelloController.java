package com.heng.reading.apiservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heng
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello, world";
    }
}
