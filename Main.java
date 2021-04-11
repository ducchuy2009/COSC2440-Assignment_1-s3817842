package com.company;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner inp = new Scanner(System.in);
        Student s;
        Course c;
        String sID, cID, sem, opt, opt1, opt2;
        Pattern regex = Pattern.compile("\\d{4}[A-C]$");
        EnrolmentManager enrolment = new EnrolmentManager();

        if (enrolment.importFile("C:\\Users\\LENOVO\\IdeaProjects\\Assignment_1\\src\\com\\company\\StudentEnrolmentSystem.csv")) {

            do {
                System.out.println("----------------------------------------------");
                System.out.println("1. Enroll");
                System.out.println("2. Update");
                System.out.println("3. View");
                System.out.println("4. Exit");
                System.out.print("Enter your option: ");
                opt = inp.nextLine();
                int temp = Integer.parseInt(opt);
                System.out.println("----------------------------------------------");

                if ((temp >= 1) && (temp <= 4)) {
                    switch (opt) {
                        case "1":
                            do {
                                System.out.println("----------------------------------------------");
                                System.out.print("Enter a Student ID: ");
                                sID = inp.nextLine().toUpperCase();
                                s = enrolment.isStudentValid(sID);
                                System.out.println("----------------------------------------------");
                            } while (s == null);

                            do {
                                System.out.println("----------------------------------------------");
                                System.out.print("Enter a Course ID: ");
                                cID = inp.nextLine();
                                c = enrolment.isCourseValid(cID);
                                System.out.println("----------------------------------------------");
                            } while (c == null);

                            do {
                                System.out.println("----------------------------------------------");
                                System.out.print("Enter a Semester: ");
                                sem = inp.nextLine();
                                System.out.println("----------------------------------------------");
                            } while (!Pattern.matches(String.valueOf(regex), sem));

                            StudentEnrolment se = new StudentEnrolment(s, c, sem);
                            if (enrolment.add(se)) {
                                System.out.println("Enroll Successfully");
                            }
                            else {
                                System.out.println("Already was there");
                            }
                            break;

                        case "2":
                            do {
                                System.out.println("----------------------------------------------");
                                System.out.print("Enter a Student ID: ");
                                sID = inp.nextLine();
                                s = enrolment.isStudentValid(sID);
                                System.out.println("----------------------------------------------");
                            } while (s == null);

                            enrolment.displayCourse(sID);

                            do {
                                System.out.println("----------------------------------------------");
                                System.out.println("1. Add a new course");
                                System.out.println("2. Delete a enrolment");
                                System.out.println("3. Back");
                                System.out.print("Enter your option: ");
                                opt1 = inp.nextLine();
                                System.out.println("----------------------------------------------");
                            } while ((Integer.parseInt(opt1) <= 1)
                                    && (Integer.parseInt(opt1) >= 2));

                            switch (opt1) {
                                case "1":
                                    enrolment.update();
                                case "2":
                                    enrolment.delete();
                            }
                            break;

                        case "3":
                            do {
                                System.out.println("----------------------------------------------");
                                System.out.println("1. View all courses of a student in a semester");
                                System.out.println("2. View all students in a course in a semester");
                                System.out.println("3. View all course offered in a semester");
                                System.out.println("4. View all enrolments/ students/ courses");
                                System.out.println("5. Back");
                                System.out.print("Enter your option: ");
                                opt2 = inp.nextLine();
                                System.out.println("----------------------------------------------");
                            } while ((Integer.parseInt(opt2) <= 1) && (Integer.parseInt(opt2) >= 4));

                            enrolment.view(opt2);
                            break;

                        case "4":
                            break;
                    }
                } else {
                    System.out.println("----------------------------------------------");
                    System.out.println("Invalid Option!");
                    System.out.println("----------------------------------------------");
                }
            } while (!opt.equals("4"));
        }
    }
}
