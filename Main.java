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
                do {
                    System.out.println("----------------------------------------------");
                    System.out.println("1. Enroll");
                    System.out.println("2. Update");
                    System.out.println("3. View");
                    System.out.println("4. Exit");
                    System.out.print("Enter your option: ");
                    opt = inp.nextLine();
                    System.out.println("----------------------------------------------");
                } while ((!opt.equals("1"))
                        && (!opt.equals("2"))
                        && (!opt.equals("3"))
                        && (!opt.equals("4")));

                if ((Integer.parseInt(opt) >= 1)
                        && (Integer.parseInt(opt) <= 4)) {
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
                                cID = inp.nextLine().toUpperCase();
                                c = enrolment.isCourseValid(cID);
                                System.out.println("----------------------------------------------");
                            } while (c == null);

                            do {
                                System.out.println("----------------------------------------------");
                                System.out.print("Enter a Semester: ");
                                sem = inp.nextLine().toUpperCase();
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
                                sID = inp.nextLine().toUpperCase();
                                s = enrolment.isStudentValid(sID);
                                System.out.println("----------------------------------------------");
                            } while (s == null);

                            System.out.println(s.getName() + "'s Course List: ");
                            int noCourse = enrolment.displayCourseOfStudent(sID);

                            do {
                                System.out.println("----------------------------------------------");
                                System.out.println("1. Add a new course");
                                System.out.println("2. Delete a enrolment");
                                System.out.println("3. Back");
                                System.out.print("Enter your option: ");
                                opt1 = inp.nextLine();
                                System.out.println("----------------------------------------------");
                            } while (!opt1.equals("1")
                                    && (!opt1.equals("2"))
                                    && (!opt1.equals("3")));

                            switch (opt1) {
                                case "1":
                                    do {
                                        System.out.println("----------------------------------------------");
                                        System.out.print("Enter a Course ID: ");
                                        cID = inp.nextLine().toUpperCase();
                                        c = enrolment.isCourseValid(cID);
                                        System.out.println("----------------------------------------------");
                                    } while (c == null);

                                    do {
                                        System.out.println("----------------------------------------------");
                                        System.out.print("Enter a Semester: ");
                                        sem = inp.nextLine().toUpperCase();
                                        System.out.println("----------------------------------------------");
                                    } while (!Pattern.matches(String.valueOf(regex), sem));

                                    enrolment.update(s, c, sem);
                                    break;

                                case "2":
                                    enrolment.delete(enrolment.getOne(noCourse, sID));
                                    break;
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
                            } while (!opt2.equals("1")
                                    && !opt2.equals("2")
                                    && !opt2.equals("3")
                                    && !opt2.equals("4")
                                    && !opt2.equals("5"));

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
