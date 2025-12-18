package main;

import student.*;
import view.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        // Create StudentManager, in charge of the logic of the system
        StudentManager sm = new StudentManager();

        // Create StudentView, in charge of the UI
        StudentView sv = new StudentView(sm);

        // Run the UI to start the system
        sv.run();
    }
}
