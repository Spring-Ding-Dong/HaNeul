package com.springDingDong.haneul.assignment2;

import com.springDingDong.haneul.assignment1.StudyLeader;
import com.springDingDong.haneul.assignment1.StudyMember;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/study")
@RequiredArgsConstructor
public class StudyMemberController {

    @PersistenceContext
    private EntityManager em;

    //1. 팀원 추가
    @Transactional
    @PostMapping("/member")
    public String addMember(@RequestParam String name, @RequestParam int age) {
        StudyMember member = new StudyMember(name, age);
        em.persist(member);
        return name + "팀원으로 추가되었습니더.";
    }
    //2. 팀원 목록 조회
    @GetMapping("/members")
    public List<StudyMember> getAllMembers() {
        return em.createQuery("select m from StudyMember m", StudyMember.class).getResultList();
    }
    //3. 특정 팀원 조회
    @GetMapping("/member/{name}")
    public StudyMember getMember(@PathVariable String name) {
        List<StudyMember> members = em.createQuery("select m from StudyMember m where m.name = :name ",StudyMember.class)
                .setParameter("name", name)
                .getResultList();

        return members.isEmpty() ? null : members.get(0);
    }
    //4. 팀원 정보 수정 (나이만 변경 가능)
    @Transactional
    @PutMapping("/member/{name}")
    public String updateMember(@PathVariable String name, @RequestParam int age) {
        StudyMember member = getMember(name);
        member.setAge(age);
        em.merge(member);
        return name + "님의 정보가 수정되었습니다.";
    }
    //5. 팀원 삭제
    @Transactional
    @DeleteMapping("/member")
    public String deleteMember(@RequestParam String name) {
        StudyMember member = getMember(name);
        em.remove(member);
        return name + "님이 삭제되었습니다.";
    }


}
