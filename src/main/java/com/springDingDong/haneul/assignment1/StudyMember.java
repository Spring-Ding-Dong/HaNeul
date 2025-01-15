package com.springDingDong.haneul.assignment1;

public class StudyMember implements PDAStudyUser {

    private String name;
    private int age;
    private int attendanceCount;

    public StudyMember(String name, int age) {
        this.name = name;
        this.age = age;
        this.attendanceCount = 0;
    }

    //Getter and Setter
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

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    public void incrementAttendanceCount() {
        this.attendanceCount++;
    }

    @Override
    public void recordAttendance() {
        incrementAttendanceCount();
        System.out.println( name + "님의 출결 현황: "+attendanceCount);
    }
}
