package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int opt, opt1;
        String sID, cID, sem;
        EnrolmentManager enrolment = new EnrolmentManager();
        do {
            System.out.println("-------------------");
            System.out.println("1. Enroll");
            System.out.println("2. Update");
            System.out.println("3. View");
            System.out.println("4. Exit");
            System.out.println("Enter your option: ");
            opt = inp.nextInt();
            System.out.println("-------------------");

            switch (opt) {
                case 1:
                    System.out.println("Enter a Student ID: ");
                    sID = inp.nextLine();
                    System.out.println("Enter a Course ID: ");
                    cID = inp.nextLine();
                    System.out.println("Enter a Semester: ");
                    sem = inp.nextLine();
                    StudentEnrolment se = new StudentEnrolment(sID, cID, sem);
                    se.Enroll(se);

                case 2:
                    

                case 3:
                    enrolment.getAll();
                    System.out.println("----------------------------------------------");
                    System.out.println("1. View all courses of a student in a semester");
                    System.out.println("2. View all students in a course in a semester");
                    System.out.println("3. View all course offered in a semester");
                    System.out.println("4. Back");
                    System.out.println("Enter your option: ");
                    opt1 = inp.nextInt();
                    System.out.println("----------------------------------------------");
                    enrolment.getOne(opt1);
                    
                case 4:
                    break;
            }
        } while (opt != 4);
    }
}
