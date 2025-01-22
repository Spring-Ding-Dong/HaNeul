package com.springDingDong.haneul.week2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(method = RequestMethod.GET, value = "study")
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("name/{name}")
    public String getName(@PathVariable(value = "name") final String name) {
        return name;
    }

    @GetMapping("/pda")
    public String getPart(@RequestParam(value = "part", defaultValue = "") final String part,
                          @RequestParam(value = "age", defaultValue = "") final int age) {

        return "파트는 " + part + "이, 고" + age + "입니다.";

    }
}
