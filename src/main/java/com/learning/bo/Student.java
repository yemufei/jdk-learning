package com.learning.bo;

import lombok.Data;

import java.util.Objects;

/**
 * @author: mufei
 * @date: 2022/8/21 05:47
 * @Description:
 */
@Data
public class Student {

    // 姓名
    private String stuNm;

    // 年龄
    private String age;

    // 构造函数
    public Student(String stuNm, String age) {
        this.stuNm = stuNm;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(stuNm, student.stuNm) && Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuNm, age);
    }
}
