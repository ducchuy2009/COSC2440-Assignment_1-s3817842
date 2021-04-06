package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnrolmentManager  {
    List<StudentEnrolment> studentEnrolmentList = new ArrayList<>();
    List<String> studentList = new ArrayList<>();
    List<String> coursesList = new ArrayList<>();

    public EnrolmentManager() {
    }

    public boolean add (StudentEnrolment se) {
        if (studentEnrolmentList.contains(se)) {
            return false;
        }
        studentEnrolmentList.add(se);
        return true;
    }

    public void getOne(int option) {
        Scanner input = new Scanner(System.in);
        String studentID, courseID, semester;
        switch (option) {
            case 1:
                System.out.println("Enter a Student ID: ");
                studentID = input.nextLine();
                System.out.println("Enter a Semester");
                semester = input.nextLine();
                for (StudentEnrolment se: studentEnrolmentList) {
                    if ((se.getStudent().equals(studentID)) && (se.getSemester().equals(semester))) {
                        System.out.print(se.getCourse() + ", ");
                    }
                }

            case 2:
                System.out.println("Enter a Course ID: ");
                courseID = input.nextLine();
                System.out.println("Enter a Semester");
                semester = input.nextLine();
                for (StudentEnrolment se: studentEnrolmentList) {
                    if ((se.getCourse().equals(courseID)) && (se.getSemester().equals(semester))) {
                        System.out.print(se.getStudent() + ", ");
                    }
                }

            case 3:
                System.out.println("Enter a Semester");
                semester = input.nextLine();
                for (StudentEnrolment se: studentEnrolmentList) {
                    if  (se.getSemester().equals(semester)) {
                        System.out.print(se.getCourse() + ", ");
                    }
                }
        }
    }

    public void displayStudentEnrolment() {
        for (StudentEnrolment se: studentEnrolmentList) {
            System.out.println("Student: " + se.getStudent() + ", Course: " + se.getCourse() + ", Semester: " + se.getSemester());
        }
    }
}
