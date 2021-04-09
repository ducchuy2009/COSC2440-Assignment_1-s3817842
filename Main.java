package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String sID, cID, sem, opt, opt1, opt2;
        EnrolmentManager enrolment = new EnrolmentManager();
        do {
            System.out.println("-------------------");
            System.out.println("1. Enroll");
            System.out.println("2. Update");
            System.out.println("3. View");
            System.out.println("4. Exit");
            System.out.println("Enter your option: ");
            opt = inp.nextLine();
            System.out.println("-------------------");

            switch (opt) {
                case "1":
                    System.out.println("Enter a Student ID: ");
                    sID = inp.nextLine();
                    System.out.println("Enter a Course ID: ");
                    cID = inp.nextLine();
                    System.out.println("Enter a Semester: ");
                    sem = inp.nextLine();
                    StudentEnrolment se = new StudentEnrolment(sID, cID, sem);
                    se.Enroll(se);

                case "2":
                    System.out.println("Enter a Student ID");
                    sID = inp.nextLine();
                    enrolment.displayCourse(sID);
                    System.out.println("1. Add a new course");
                    System.out.println("2. Delete a enrolment");
                    System.out.println("3. Back");
                    System.out.println("Enter your option: ");
                    opt1 = inp.nextLine();
                    switch (opt1) {
                        case "1":
                            enrolment.update();
                        case "2":
                            enrolment.delete();
                    }

                case "3":
                    enrolment.getAll("4");
                    System.out.println("----------------------------------------------");
                    System.out.println("1. View all courses of a student in a semester");
                    System.out.println("2. View all students in a course in a semester");
                    System.out.println("3. View all course offered in a semester");
                    System.out.println("4. View all enrolments/ students/ courses");
                    System.out.println("5. Back");
                    System.out.println("Enter your option: ");
                    opt2 = inp.nextLine();
                    System.out.println("----------------------------------------------");
                    enrolment.view(opt2);
                    
                case "4":
                    break;
            }
        } while (!opt.equals("5"));
    }
}
