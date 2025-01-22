package com.springDingDong.haneul.assignment1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PDAStudyUserTest {

    @Test
    void testStudyMember() {
        StudyMember studyMember= new StudyMember("이하늘",26);

        //1회 출석
        studyMember.recordAttendance();
        //2회 출석
        studyMember.recordAttendance();

        assert studyMember.getAttendanceCount() == 2;

        studyMember.introduce();
    }
    @Test
    void testStudyLeader(){

        StudyLeader studyLeader = new StudyLeader("김동재", 25);
        studyLeader.recordAttendance();
        studyLeader.introduce();
    }

    @Test
    void testStaticMethod(){

        PDAStudyUser.printStudyRules();
    }
}