package com.company;

import java.text.ParseException;

public class StudentEnrolment {
    private Student student;
    private Course course;
    private String semester;

    public StudentEnrolment(Student student, Course course, String semester) {
        super();
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public static StudentEnrolment parseCsv(String enrolmentInfo) throws ParseException {
        String[] splitInfo = enrolmentInfo.split(",");
        int noCredits = Integer.parseInt(splitInfo[5]);
        Student s = new Student(splitInfo[0], splitInfo[1], splitInfo[2]);
        Course c = new Course(splitInfo[3], splitInfo[4], noCredits);
        StudentEnrolment enrolment = new StudentEnrolment(s, c, splitInfo[6]);
        return enrolment;
    }
}


