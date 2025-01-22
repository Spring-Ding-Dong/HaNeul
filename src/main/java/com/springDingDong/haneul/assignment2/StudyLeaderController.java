package com.springDingDong.haneul.assignment2;

import com.springDingDong.haneul.assignment1.StudyLeader;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/study")
@RequiredArgsConstructor
public class StudyLeaderController {

    @PersistenceContext
    private final EntityManager em;

    private StudyLeader leader;

    // 1. 팀장 추가
    @Transactional
    @PostMapping("/leader")
    public String addLeader(@RequestParam String name, @RequestParam int age) {
        List<StudyLeader> leaders = em.createQuery("SELECT l FROM StudyLeader l", StudyLeader.class).getResultList();
        StudyLeader leader = new StudyLeader(name, age);
        em.persist(leader);
        return name + "님이 팀장으로 추가되었습니다.";
    }
    //2. 팀장 전체 조회
    @GetMapping("/leader")
    public List<StudyLeader> getLeader() {
        return em.createQuery("SELECT l FROM StudyLeader l", StudyLeader.class).getResultList();
    }

    // 3. 특정 팀장 조회
    @GetMapping("/leader/{name}")
    public StudyLeader getLeaderByName(@PathVariable String name) {
        List<StudyLeader> leaders = em.createQuery("SELECT l FROM StudyLeader l WHERE l.name = :name", StudyLeader.class)
                .setParameter("name", name)
                .getResultList();
        return leaders.isEmpty() ? null : leaders.get(0);
    }
    // 4. 팀장 정보 수정
    @Transactional
    @PutMapping("/leader/{name}")
    public String updateLeader(@PathVariable String name, @RequestParam int age) {
        StudyLeader leader = getLeaderByName(name);
        leader.setAge(age);
        em.merge(leader);
        return name + "님의 정보가 수정되었습니다.";
    }

    // 5. 팀장 삭제
    @Transactional
    @DeleteMapping("/leader/{name}")
    public String deleteLeader(@PathVariable String name) {
        StudyLeader leader = getLeaderByName(name);
        em.remove(leader);
        return name + "님이 팀장에서 삭제되었습니다.";
    }
}
