package com.springDingDong.haneul.assignment1;

public class StudyLeader implements PDAStudyUser{

    private String name;
    private int age;

    public StudyLeader(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void recordAttendance() {
        System.out.println( name + "님은 팀장님이라 출결처리 안해욤~ ");
    }
    @Override
    public void introduce() {
        System.out.println("안녕하세요~ "+GROUP_NAME+ "의 팀장입니다~");
    }
}
