package com.springDingDong.haneul.assignment1;

//PDA 스터디 User interface
public interface PDAStudyUser {

    //상수 필드 -> 스터디 이름~ 스프링딩동~~
    String GROUP_NAME = "Spring Ding Dong";

    //추상 메소드 -> 가이드만 제공
    //출결 기록 함수
    void recordAttendance();

    //디폴트 메소드 -> 구현 해도 되고~ 안해도 됨~
    //스터디 참여 정보 출력 하는 함수
    default void introduce(){
        System.out.println("안녕하세요~ "+GROUP_NAME+ "의 팀원입니다~");
    }

    //정적 메소드 -> 무조건 따라야해~~!!
    //스터디 규칙
    static void printStudyRules(){
        System.out.println("GROUP_NAME = " + GROUP_NAME+" 스터디의 규칙은 빠지면 벌금 5마넌~");
    }

}
