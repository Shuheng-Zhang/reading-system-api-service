package com.heng.reading.apiservice.controller;

import com.heng.reading.apiservice.comms.data.ResultData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heng
 */
@RequestMapping("/test")
@RestController
public class HelloController {

    @GetMapping("hello")
    public ResultData<String> hello() {
        return ResultData.success("Hello, World");
    }
}
