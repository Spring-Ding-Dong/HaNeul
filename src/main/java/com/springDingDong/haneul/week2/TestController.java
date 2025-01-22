package com.springDingDong.haneul.week2;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @PostMapping("member")
    public String member(@RequestBody final Member member) {
        return member.getName();
    }

    @GetMapping("name/{name}")
    public String name(@PathVariable (value = "name") final String name) {
        return name;
    }
}
