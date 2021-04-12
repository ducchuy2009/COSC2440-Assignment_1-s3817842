package com.company;

public interface StudentEnrolmentManager {
    boolean add(StudentEnrolment se);
    void update(Student s, Course c, String sem);
    void delete(StudentEnrolment enrolment);
    StudentEnrolment getOne(int limitSize, String studentID);
    void getAll(String opt);
}
