package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Student {
    private String id;
    private String name;
    private Date birthdate;
    private ArrayList<Course> courseList;

    public Student(String id, String name, Date birthdate) {
        super();
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        courseList = new ArrayList<Course>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", courseList=" + courseList +
                '}';
    }
}

