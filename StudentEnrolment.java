package com.company;

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

    public String getStudent() {
        return student;
    }

    public String getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public void enroll(StudentEnrolment enrolment) {
        EnrolmentManager em = new EnrolmentManager();
        if (em.add(enrolment)) {
            System.out.println("Enroll Successfully!");
        }
        else {
            System.out.println("Already is there!");
        }
    }
}


