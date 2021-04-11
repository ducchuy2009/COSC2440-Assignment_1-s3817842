package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EnrolmentManager  {
    private ArrayList<Student> studentList;
    private ArrayList<Course> coursesList;
    private ArrayList<StudentEnrolment> studentEnrolmentList;

    public EnrolmentManager() {
        studentList = new ArrayList<>();
        coursesList = new ArrayList<>();
        studentEnrolmentList = new ArrayList<>();
    }

    public boolean importFile(String fileName) throws ParseException {
        Scanner input;
        try {
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            return false;
        }
        while (input.hasNextLine()) {
            String line = input.nextLine();
            StudentEnrolment se = StudentEnrolment.parseCsv(line);
            studentEnrolmentList.add(se);
            studentList.add(se.getStudent());
            coursesList.add(se.getCourse());
        }
        input.close();
        return true;
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
        Student s;
        Course c;
        EnrolmentManager enrolment = new EnrolmentManager();
        String studentID, courseID, semester, opt;
        Pattern regex = Pattern.compile("\\d{4}[A-C]$");
        switch (option) {
            case "1":
                do {
                    System.out.println("----------------------------------------------");
                    System.out.print("Enter a Student ID: ");
                    studentID = input.nextLine();
                    s = enrolment.isStudentValid(studentID);
                    System.out.println("----------------------------------------------");
                } while (s == null);

                do {
                    System.out.println("----------------------------------------------");
                    System.out.print("Enter a Semester: ");
                    semester = input.nextLine();
                    System.out.println("----------------------------------------------");
                } while (!Pattern.matches(String.valueOf(regex), semester));

                for (StudentEnrolment se: studentEnrolmentList) {
                    if ((se.getStudent().equals(s)) && (se.getSemester().equals(semester))) {
                        System.out.print(se.getCourse() + ", ");
                    }
                }
                break;

            case "2":
                do {
                    System.out.println("----------------------------------------------");
                    System.out.print("Enter a Course ID: ");
                    courseID = input.nextLine();
                    c = enrolment.isCourseValid(courseID);
                    System.out.println("----------------------------------------------");
                } while (c == null);

                do {
                    System.out.println("----------------------------------------------");
                    System.out.print("Enter a Semester: ");
                    semester = input.nextLine();
                    System.out.println("----------------------------------------------");
                } while (!Pattern.matches(String.valueOf(regex), semester));

                for (StudentEnrolment se: studentEnrolmentList) {
                    if ((se.getCourse().equals(c)) && (se.getSemester().equals(semester))) {
                        System.out.print(se.getStudent() + ", ");
                    }
                }
                break;

            case "3":
                do {
                    System.out.println("----------------------------------------------");
                    System.out.print("Enter a Semester: ");
                    semester = input.nextLine();
                    System.out.println("----------------------------------------------");
                } while (!Pattern.matches(String.valueOf(regex), semester));

                for (StudentEnrolment se: studentEnrolmentList) {
                    if  (se.getSemester().equals(semester)) {
                        System.out.print(se.getCourse() + ", ");
                    }
                }
                break;

            case "4":
                do {
                    System.out.println("----------------------------------------------");
                    System.out.println("1. View all enrolments");
                    System.out.println("2. View all students");
                    System.out.println("3. View all courses");
                    System.out.println("4. View all information");
                    System.out.println("5. Back");
                    System.out.print("Enter your option: ");
                    opt = input.nextLine();
                } while ((Integer.parseInt(opt) <= 1)
                    && (Integer.parseInt(opt) >= 5));
                getAll(opt);
                break;
        }
    }

    public void getAll(String opt) {
        switch (opt) {
            case "1":
                for (StudentEnrolment enrolment : studentEnrolmentList) {
                    System.out.println("Student: " + enrolment.getStudent().getId() + " "
                            + "Course: " + enrolment.getCourse().getId() + " "
                            + "Semester: " + enrolment.getSemester());
                }
                break;

            case "2":
                for (Student s : studentList) {
                    System.out.println("ID: " + s.getId() + " "
                            + "Name: " + s.getName() + " "
                            + "DOB: " + s.getBirthdate());
                }
                break;

            case "3":
                for (Course c : coursesList) {
                    System.out.println("ID: " + c.getId() + " "
                            + "Name: " + c.getName() + " "
                            + "Number of Credits: " + c.getNoCredits());
                }
                break;

            case "4":
                for (StudentEnrolment enrolment : studentEnrolmentList) {
                    System.out.println("Student: " + enrolment.getStudent().getId() + " "
                            + "Course: " + enrolment.getCourse().getId() + " "
                            + "Semester: " + enrolment.getSemester());
                }

                for (Student s : studentList) {
                    System.out.println("ID: " + s.getId() + " "
                            + "Name: " + s.getName() + " "
                            + "DOB: " + s.getBirthdate());
                }

                for (Course c : coursesList) {
                    System.out.println("ID: " + c.getId() + " "
                            + "Name: " + c.getName() + " "
                            + "Number of Credits: " + c.getNoCredits());
                }
                break;
        }
    }

    public Student isStudentValid(String studentID) {
        for (Student s : studentList) {
            if (s.getId().equals(studentID)) {
                return s;
            }
        }
        System.out.println("Student is not valid");
        return null;
    }

    public Course isCourseValid(String courseID) {
        for (Course c : coursesList) {
            if (c.getId().equals(courseID)) {
                return c;
            }
        }
        System.out.println("Course is not valid");
        return null;
    }

    public void displayCourse(String studentID) {
        int enrolmentID = 0;
        for (StudentEnrolment se: studentEnrolmentList) {
            if (se.getStudent().equals(studentID)) {
                enrolmentID++;
                System.out.println(enrolmentID + "  " + se.getCourse());
            }
        }
    }
}
