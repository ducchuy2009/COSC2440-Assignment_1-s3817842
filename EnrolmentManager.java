package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EnrolmentManager implements StudentEnrolmentManager{
    private List<Student> studentList;
    private List<Course> coursesList;
    private List<StudentEnrolment> studentEnrolmentList;

    public EnrolmentManager() {
        studentList = new ArrayList<>();
        coursesList = new ArrayList<>();
        studentEnrolmentList = new ArrayList<>();
    }

    public void importFile(String fileName) throws FileNotFoundException {

        // Declare Variables
        Scanner input;
        List<String> sID = new ArrayList<>();
        List<String> cID = new ArrayList<>();

        // Open File
        try {
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            System.out.println("Run default file");
            input = new Scanner(new File("C:\\Users\\LENOVO\\IdeaProjects\\Assignment_1\\src\\com\\company\\default.csv"));
        }

        // Import Data from file in the system
        while (input.hasNextLine()) {
            String line = input.nextLine();
            StudentEnrolment se = StudentEnrolment.parseCsv(line);
            studentEnrolmentList.add(se);
            if (!sID.contains(se.getStudent().getId())) {
                sID.add(se.getStudent().getId());
                studentList.add(se.getStudent());
            }
            if (!cID.contains(se.getCourse().getId())) {
                cID.add(se.getCourse().getId());
                coursesList.add(se.getCourse());
            }
        }

        input.close();
    }

    public boolean add(StudentEnrolment enrolment) {
        for (StudentEnrolment se : studentEnrolmentList) {
            // If enrolment is available
            if ((enrolment.getStudent().equals(se.getStudent()))
                    && (enrolment.getCourse().equals(se.getCourse()))) {
                return false;
            }
        }
        // Enrolment added if not available
        studentEnrolmentList.add(enrolment);
        return true;
    }

    public boolean update(Student s, Course c, String sem) {

        StudentEnrolment enrolment = new StudentEnrolment(s, c, sem);

        // Check enrolment is available or not
        if (add(enrolment)) {
            return true;
        }
        else return false;
    }

    public void delete(StudentEnrolment enrolment){
        // Delete enrolment based on details
        studentEnrolmentList.remove(enrolment);
        System.out.println("Enrolment deleted successfully");
    }

    public void view(String option) {

        // Declare variables
        Scanner input = new Scanner(System.in);
        Student s;
        Course c;
        String studentID, courseID, semester, opt;
        Pattern regex = Pattern.compile("\\d{4}[A-C]$");

        // Check option from users
        switch (option) {

            // Display Course List of a Student in a Semester
            case "1":

                // Enter Student ID
                do {
                    System.out.println("----------------------------------------------");
                    System.out.print("Enter a Student ID: ");
                    studentID = input.nextLine().toUpperCase();
                    s = isStudentValid(studentID);
                    System.out.println("----------------------------------------------");
                } while (s == null);

                // Enter Semester
                do {
                    System.out.println("----------------------------------------------");
                    System.out.print("Enter a Semester: ");
                    semester = input.nextLine().toUpperCase();
                    System.out.println("----------------------------------------------");
                } while (!Pattern.matches(String.valueOf(regex), semester));

                // Display Course List
                System.out.println("COURSE LIST:");
                System.out.println("--------------------------------------------------------------");
                System.out.format("|%-13s|%-32s|%-13s|", "ID", "Name", "No. Credits");
                System.out.println();
                System.out.println("--------------------------------------------------------------");
                for (StudentEnrolment se: studentEnrolmentList) {
                    if ((se.getStudent().equals(s))
                            && (se.getSemester().equals(semester))) {
                        System.out.format("|%-13s|%-32s|%-13s|",
                                se.getCourse().getId(),
                                se.getCourse().getName(),
                                se.getCourse().getNoCredits());
                        System.out.println();
                    }
                }
                System.out.println("--------------------------------------------------------------");
                break;

            // Display Student List in a Course of a Semester
            case "2":

                // Enter Course ID
                do {
                    System.out.println("----------------------------------------------");
                    System.out.print("Enter a Course ID: ");
                    courseID = input.nextLine().toUpperCase();
                    c = isCourseValid(courseID);
                    System.out.println("----------------------------------------------");
                } while (c == null);

                // Enter Semester
                do {
                    System.out.println("----------------------------------------------");
                    System.out.print("Enter a Semester: ");
                    semester = input.nextLine().toUpperCase();
                    System.out.println("----------------------------------------------");
                } while (!Pattern.matches(String.valueOf(regex), semester));

                // Display Student List
                System.out.println("STUDENT LIST:");
                System.out.println("--------------------------------------------------------------");
                System.out.format("|%-13s|%-32s|%-13s|", "ID", "Name", "DOB");
                System.out.println();
                System.out.println("--------------------------------------------------------------");
                for (StudentEnrolment se: studentEnrolmentList) {
                    if ((se.getCourse().getId().equals(c.getId())) &&
                            (se.getSemester().equals(semester))) {
                        System.out.format("|%-13s|%-32s|%-13s|",
                                se.getStudent().getId(),
                                se.getStudent().getName(),
                                se.getStudent().getBirthdate());
                        System.out.println();
                    }
                }
                System.out.println("--------------------------------------------------------------");

                break;

            // Display all Course that offered in a semester
            case "3":

                // Enter a Semester
                do {
                    System.out.println("----------------------------------------------");
                    System.out.print("Enter a Semester: ");
                    semester = input.nextLine().toUpperCase();
                    System.out.println("----------------------------------------------");
                } while (!Pattern.matches(String.valueOf(regex), semester));

                // Repeat List is responsible to help the system avoid the duplication
                List<String> repeat = new ArrayList<>();

                // Display Course List
                System.out.println("COURSE LIST:");
                System.out.println("--------------------------------------------------------------");
                System.out.format("|%-13s|%-32s|%-13s|", "ID", "Name", "No. Credits");
                System.out.println();
                System.out.println("--------------------------------------------------------------");
                for (StudentEnrolment se: studentEnrolmentList) {
                    if  (se.getSemester().equals(semester)) {
                        if (!repeat.contains(se.getCourse().getId())) { // Check the Course is duplicate or not
                            repeat.add(se.getCourse().getId());
                            System.out.format("|%-13s|%-32s|%-13s|",
                                    se.getCourse().getId(),
                                    se.getCourse().getName(),
                                    se.getCourse().getNoCredits());
                            System.out.println();
                        }
                    }
                }
                System.out.println("--------------------------------------------------------------");

                break;

            // View All
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
                } while ((!opt.equals("1"))
                    && (!opt.equals("2"))
                    && (!opt.equals("3"))
                    && (!opt.equals("4"))
                    && (!opt.equals("5")));
                getAll(opt);
                break;
        }
    }

    // Return the enrolment information based on the entered index
    public StudentEnrolment getOne(int limitSize, String studentID) {
        Scanner input = new Scanner(System.in);
        String index;

        // Choose the index of the enrolment details in the displayed broad (update function)
        do {
            System.out.print("Choose the index that you want to delete: ");
            index = input.nextLine();
        } while ((Integer.parseInt(index) <= 0)
                && (Integer.parseInt(index)) > limitSize);

        int line = 0;
        for (StudentEnrolment se : studentEnrolmentList) {
            if (se.getStudent().getId().equals(studentID)) {
                line++;
            }
            if (Integer.parseInt(index) == line) {
                return se;
            }
        }
        return null;
    }

    // Display All Information
    public void getAll(String opt) {
        switch (opt) {

            // Display All Enrolment Details
            case "1":
                System.out.println("ENROLMENT LIST:");
                System.out.println("-------------------------------------------");
                System.out.format("|%-13s|%-13s|%-13s|", "Student ID", "Course ID", "Semester");
                System.out.println();
                System.out.println("-------------------------------------------");
                for (StudentEnrolment enrolment : studentEnrolmentList) {
                    System.out.format("|%-13s|%-13s|%-13s|",
                            enrolment.getStudent().getId(),
                            enrolment.getCourse().getId(),
                            enrolment.getSemester());
                    System.out.println();
                }
                System.out.println("-------------------------------------------");
                break;

            // Display All Students' Details
            case "2":
                System.out.println("STUDENT LIST:");
                System.out.println("--------------------------------------------------------------");
                System.out.format("|%-13s|%-32s|%-13s|", "ID", "Name", "DOB");
                System.out.println();
                System.out.println("--------------------------------------------------------------");
                for (Student s : studentList) {
                    System.out.format("|%-13s|%-32s|%-13s|",
                            s.getId(),
                            s.getName(),
                            s.getBirthdate());
                    System.out.println();
                }
                System.out.println("--------------------------------------------------------------");
                break;

            // Display All Courses' Details
            case "3":
                System.out.println("COURSE LIST:");
                System.out.println("--------------------------------------------------------------");
                System.out.format("|%-13s|%-32s|%-13s|", "ID", "Name", "No. Credits");
                System.out.println();
                System.out.println("--------------------------------------------------------------");
                for (Course c : coursesList) {
                    System.out.format("|%-13s|%-32s|%-13s|",
                            c.getId(),
                            c.getName(),
                            c.getNoCredits());
                    System.out.println();
                }
                System.out.println("--------------------------------------------------------------");
                break;

            // Display All Information in the system
            case "4":
                System.out.println("ENROLMENT LIST:");
                System.out.println("-------------------------------------------");
                System.out.format("|%-13s|%-13s|%-13s|", "Student ID", "Course ID", "Semester");
                System.out.println();
                System.out.println("-------------------------------------------");
                for (StudentEnrolment enrolment : studentEnrolmentList) {
                    System.out.format("|%-13s|%-13s|%-13s|",
                            enrolment.getStudent().getId(),
                            enrolment.getCourse().getId(),
                            enrolment.getSemester());
                    System.out.println();
                }
                System.out.println("-------------------------------------------");

                System.out.println("STUDENT LIST:");
                System.out.println("--------------------------------------------------------------");
                System.out.format("|%-13s|%-32s|%-13s|", "ID", "Name", "DOB");
                System.out.println();
                System.out.println("--------------------------------------------------------------");
                for (Student s : studentList) {
                    System.out.format("|%-13s|%-32s|%-13s|",
                            s.getId(),
                            s.getName(),
                            s.getBirthdate());
                    System.out.println();
                }
                System.out.println("--------------------------------------------------------------");

                System.out.println("COURSE LIST:");
                System.out.println("--------------------------------------------------------------");
                System.out.format("|%-13s|%-32s|%-13s|", "ID", "Name", "No. Credits");
                System.out.println();
                System.out.println("--------------------------------------------------------------");
                for (Course c : coursesList) {
                    System.out.format("|%-13s|%-32s|%-13s|",
                            c.getId(),
                            c.getName(),
                            c.getNoCredits());
                    System.out.println();
                }
                System.out.println("--------------------------------------------------------------");
                break;
        }
    }

    // Check the validation of Student based on ID
    public Student isStudentValid(String studentID) {
        for (Student s : studentList) {
            if (s.getId().equals(studentID)) {
                return s;
            }
        }
        System.out.println("Student is not valid");
        return null;
    }

    //Check validation of Course by ID
    public Course isCourseValid(String courseID) {
        for (Course c : coursesList) {
            if (c.getId().equals(courseID)) {
                return c;
            }
        }
        System.out.println("Course is not valid");
        return null;
    }

    // Display all Course of a Student by student ID (Update Function)
    public int displayCourseOfStudent(String studentID) {
        int index = 0;
        System.out.println("-------------------------------------------------------------------");
        System.out.format("|%-4s|%-13s|%-32s|%-13s|", "ID", "Course ID", " Course Name", "No. Credits");
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
        for (StudentEnrolment se: studentEnrolmentList) {
            if (se.getStudent().getId().equals(studentID)) {
                index++;
                System.out.format("|%-4d|%-13s|%-32s|%-13s|",
                        index,
                        se.getCourse().getId(),
                        se.getCourse().getName(),
                        se.getCourse().getNoCredits());
                System.out.println();
            }
        }
        System.out.println("-------------------------------------------------------------------");
        return index;
    }
}
