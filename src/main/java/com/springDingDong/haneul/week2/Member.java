package com.springDingDong.haneul.week2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;

    //클래스에서 기본 생성자는 필수로 있어야 함.
    //자바 빈즈가 reflection 을 이용해서 객체를 생성하는데 기본생성자가 없으면 생성을 하지 못함.
    //더 찾아보세유~
    //상속에서도 기본 생성자가 필요합니다.~
    public Member() {}

    public Member(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


}
