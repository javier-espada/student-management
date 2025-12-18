package main;

import student.*;
import view.*;

public class Main {
    public static void main(String[] args) {
        // Create StudentManager, in charge of the logic of the system
        IStudentManager sm = new StudentManager();

        // Create StudentView, in charge of the UI
        StudentView sv = new StudentView(sm);

        // Run the UI to start the system
        sv.run();
    }
}
