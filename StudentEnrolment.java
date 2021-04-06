package com.company;

import java.util.ArrayList;

public class StudentEnrolment {
    private String student;
    private String course;
    private String semester;

    public StudentEnrolment(String student, String course, String semester) {
        super();
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    public StudentEnrolment() {
    }

    public String getStudent() {
        return student;
    }

    public String getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public void Enroll(StudentEnrolment enrolment) {
        EnrolmentManager em = new EnrolmentManager();
        if (em.add(enrolment)) {
            System.out.println("Enroll Successfully!");
        }
        else {
            System.out.println("Already is there!");
        }
    }

}


