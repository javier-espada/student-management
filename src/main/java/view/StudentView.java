package view;

import exception.DuplicateStudentException;
import exception.InvalidGradeException;
import exception.NoGradesException;
import exception.StudentNotFoundException;
import student.StudentManager;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class StudentView {

    Scanner sc;
    StudentManager sm;

    public StudentView(StudentManager sm) {
        sc = new Scanner(System.in);
        this.sm = sm;
    }

    void run() {
        int option = 0;

        System.out.println("Welcome to the student management system.");

        while(true) {
            System.out.println("Select what action do you want to realise:\n");
            System.out.println("1. Add a new student to the system.");
            System.out.println("2. View student's grades.");
            System.out.println("3. Add grade to a student.");
            System.out.println("4. Get high performing students.\n");
            System.out.println("5. Exit the system.");

            option = readInt();

            if(option < 1 || option > 7) {
                handleMenuInput(option);
            } else {
                System.out.println("Please choose a valid action to perform.\n");
            }
        }
    }

    void handleMenuInput  (int option) {
        switch (option) {
            case(1): // Add student
                System.out.println("Enter the student's name to register it:");
                String name = sc.nextLine();

                try {
                    sm.addStudent(name);
                } catch (DuplicateStudentException e) {
                    System.out.println("You are trying to register the student with name: " + name + ", which is already registered in the system.");
                }

                System.out.println("Student " + name + " added to the system.");
                break;

            case(2): // View student grades
                System.out.println("Enter the student's name to check their grades:");
                String viewName = sc.nextLine();

                try {
                    System.out.println(sm.getStudentDetails(viewName));
                } catch (StudentNotFoundException e) {
                    System.out.println("The student with name: " + viewName + ", is not registered in the system.");
                } catch (NoGradesException e) {
                    System.out.println("The student with name: " + viewName + ", doesn't have any grade registered in the system.");
                }

                break;

            case(3): // Add grade to student
                System.out.println("Enter the student's name to add a grade:");
                String addName = sc.nextLine();
                System.out.println("Enter the grade (0.0-10.0):");
                double grade = readDouble();

                try {
                    sm.recordGrade(addName, grade);
                    System.out.println("Grade of " + grade + " added to the student " + addName + ".");
                } catch (StudentNotFoundException e) {
                    System.out.println("The student with name: " + addName + ", is not registered in the system.");
                } catch (InvalidGradeException e) {
                    System.out.println("The grade: " + grade + ", is out of index for the system.");
                    System.out.println("A grade must be a double between 0 and 10.");
                }

                break;

            case(4): // Get highPerformingStudent
                System.out.println("Enter minimum average grade students to display:");
                double minGrade = readDouble();

                Map<String, Double> map = sm.getHighPerformingStudents(minGrade);
                System.out.println("High performing students with an average over " + minGrade + ":");
                System.out.println(map.toString());
                break;

            case(5): // Exit
                System.out.println("Exiting the student management system . . .");
                return;

            default: // Input error
                System.out.println("Please, enter a valid input option (1-7).");
                break;
        }
    }

    int readInt() {
        boolean done = false;
        int option = 0;

        do {
            try {
                option = sc.nextInt();
                done = true;
            } catch (InputMismatchException e) {
                System.out.println("To choose an option you must enter an integer.");
            }
        } while(!done);

        return option;
    }

    double readDouble() {
        boolean done = false;
        double grade = -1;

        do {
            try {
                grade = sc.nextDouble();
                done = true;
            } catch (InputMismatchException e) {
                System.out.println("For the grade you must enter a double.");
            }
        } while(!done);

        return grade;
    }
}
