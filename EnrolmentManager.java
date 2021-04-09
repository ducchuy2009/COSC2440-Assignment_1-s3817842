package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class EnrolmentManager  {
    private ArrayList<Student> studentList;
    private ArrayList<Course> coursesList;
    private ArrayList<StudentEnrolment> studentEnrolmentList;

    public EnrolmentManager() {
        studentList = new ArrayList<>();
        coursesList = new ArrayList<>();
        studentEnrolmentList = new ArrayList<>();
    }

    public void addStudent(Student s){
        studentList.add(s);
    }

    public void addCourse(Course c){
        coursesList.add(c);
    }

    public boolean add(StudentEnrolment se) {
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

    public void getAll() {

    }
}
