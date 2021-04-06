package com.company;

import java.util.ArrayList;

public class Course {
    private String id;
    private String name;
    private int noCredits;
    private ArrayList<Student> studentList;

    public Course(String id, String name, int noCredits) {
        super();
        this.id = id;
        this.name = name;
        this.noCredits = noCredits;
        studentList = new ArrayList<Student>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNoCredits() {
        return noCredits;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public boolean enroll (Student student) {
        if (studentList.contains(student)) {
            return false;
        }
        studentList.add(student);
        student.getCourseList().add(this);
        return true;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", noCredits=" + noCredits +
                ", studentList=" + studentList +
                '}';
    }
}

