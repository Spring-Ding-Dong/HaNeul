package com.springDingDong.haneul.week2;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("request")
public class RequestController {


    private final EntityManager em;

    public RequestController(EntityManager em) {
        this.em = em;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/member")
    @Transactional
    public Long testPost(@RequestBody  Member member) {
        System.out.println("member: " + member);
        em.persist(member);
        return member.getId();
    }
}
