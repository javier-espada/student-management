package view;

import student.StudentManager;

import java.util.Scanner;

public class StudentView {

    Scanner sc;
    StudentManager sm;

    StudentView(StudentManager sm) {
        sc = new Scanner(System.in);
        this.sm = sm;
    }

    void run() {
        int option = 0;
        boolean read = false;

        System.out.println("Welcome to the student management system.");

        while(true) {
            System.out.println("Select what action do you want to realise:\n");
            System.out.println("1. Add a new student to the system.");
            System.out.println("2. View the list of students registered on the system.");
            System.out.println("3. View one student's grades.");
            System.out.println("4. View all student's grades.");
            System.out.println("5. Add grade to a student.");
            System.out.println("6. Get high performing students.\n");
            System.out.println("7. Exit the system.");

            read = false;
            do {
                System.out.println("Introduce a number: ");
                if (sc.hasNextInt()) {
                    option = sc.nextInt();
                    sc.nextLine();
                    read = true;
                } else {
                    System.out.println("Error input at Scanner.");
                    sc.nextLine();
                }
            } while (!read);

            if(option < 1 || option > 7) {
                handleMenuInput(option);
            } else {
                System.out.println("Please choose a valid action to perform.\n");
            }
        }
    }

    boolean handleMenuInput (int option) {
        switch (option) {
            case(1): // Add student
                break;
            case(2): // View students list
                break;
            case(3): // View student grades
                break;
            case(4): // View students reports
                break;
            case(5): // Add grade to student
                break;
            case(6): // Get highPerformingStudent
                break;
            case(7): // Exit
                System.out.println("Exiting the student management system . . .");
                return(true);
            default: // Input error
                System.out.println("Please, enter a valid input option (1-7).");
                break;
        }
    }

}
