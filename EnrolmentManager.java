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

    public void update() {
        System.out.println("ok");
    }

    public void delete(){
        System.out.println("ok");
    }

    public void view(String option) {
        Scanner input = new Scanner(System.in);
        String studentID, courseID, semester, opt;
        switch (option) {
            case "1":
                System.out.println("Enter a Student ID: ");
                studentID = input.nextLine();
                System.out.println("Enter a Semester: ");
                semester = input.nextLine();
                for (StudentEnrolment se: studentEnrolmentList) {
                    if ((se.getStudent().equals(studentID)) && (se.getSemester().equals(semester))) {
                        System.out.print(se.getCourse() + ", ");
                    }
                }

            case "2":
                System.out.println("Enter a Course ID: ");
                courseID = input.nextLine();
                System.out.println("Enter a Semester: ");
                semester = input.nextLine();
                for (StudentEnrolment se: studentEnrolmentList) {
                    if ((se.getCourse().equals(courseID)) && (se.getSemester().equals(semester))) {
                        System.out.print(se.getStudent() + ", ");
                    }
                }

            case "3":
                System.out.println("Enter a Semester: ");
                semester = input.nextLine();
                for (StudentEnrolment se: studentEnrolmentList) {
                    if  (se.getSemester().equals(semester)) {
                        System.out.print(se.getCourse() + ", ");
                    }
                }

            case "4":
                System.out.println("1. View all enrolments");
                System.out.println("2. View all students");
                System.out.println("3. View all courses");
                System.out.println("4. View all information");
                System.out.println("5. Back");
                System.out.println("Enter your option:");
                opt = input.nextLine();
                getAll(opt);
        }
    }

    public void getAll(String opt) {
        switch (opt) {
            case "1":
                for (StudentEnrolment enrolment : studentEnrolmentList) {
                    System.out.println(enrolment);
                }

            case "2":
                for (Student s : studentList) {
                    System.out.println(s);
                }

            case "3":
                for (Course c : coursesList) {
                    System.out.println(c);
                }

            case "4":
                for (StudentEnrolment enrolment : studentEnrolmentList) {
                    System.out.println(enrolment);
                }
                for (Student s : studentList) {
                    System.out.println(s);
                }
                for (Course c : coursesList) {
                    System.out.println(c);
                }
        }
    }

    public int displayCourse(String studentID) {
        int enrolmentID = 0;
        for (StudentEnrolment se: studentEnrolmentList) {
            if (se.getStudent().equals(studentID)) {
                enrolmentID++;
                System.out.println(enrolmentID + "  " + se.getCourse());
            }
        }
    }
}
