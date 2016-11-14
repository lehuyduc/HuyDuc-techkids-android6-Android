package com.example.lehuyduc.listviewintro.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Le Huy Duc on 08/11/2016.
 */

public class Student {
    public static final int OP_UPDATE = 1;
    public static final int OP_ADD = 0;
    private String name;
    private String gender;
    private int age;

    static final Student[] STUDENTS = {
            new Student("Đức","male",9),
            new Student("Cường","male",16)
    };

    public static ArrayList<Student> list = new ArrayList<>(Arrays.asList(STUDENTS));


    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
