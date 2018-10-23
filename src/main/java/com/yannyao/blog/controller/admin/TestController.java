package com.yannyao.blog.controller.admin;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    @ResponseBody
    public String test(){
        return "test response";
    }
}
