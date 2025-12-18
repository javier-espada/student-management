package test;

import exception.DuplicateStudentException;
import exception.NoGradesException;
import exception.StudentNotFoundException;
import org.junit.jupiter.api.Test;
import student.Student;
import student.StudentManager;

import static org.junit.jupiter.api.Assertions.*;

public class TestStudentManager {
    @Test
    public void testAddStudent() {
        final String name1 = "Juan";
        final String name2 = "Maria";
        StudentManager studentManager = new StudentManager();
        assertDoesNotThrow(()->studentManager.addStudent(name1));
        assertDoesNotThrow(()->studentManager.addStudent(name2));
        assertThrows(DuplicateStudentException.class, ()->studentManager.addStudent(name1));
    }

    @Test
    public void testRecordGrade() {
        final String name1 = "Juan";
        StudentManager studentManager = new StudentManager();
        assertDoesNotThrow(()->studentManager.addStudent(name1));
        assertThrows(NoGradesException.class, ()->studentManager.getStudentDetails(name1));
        assertDoesNotThrow(()->studentManager.recordGrade(name1, 3.0));
        assertDoesNotThrow(()->studentManager.getStudentDetails(name1));
    }

    @Test
    public void testGetStudentDetails() {
        final String name1 = "Juan";
        StudentManager studentManager = new StudentManager();
        assertThrows(StudentNotFoundException.class, ()->studentManager.getStudentDetails(name1));
        assertDoesNotThrow(()->studentManager.addStudent(name1));
        assertThrows(StudentNotFoundException.class, ()->studentManager.getStudentDetails("Paco"));
        assertThrows(NoGradesException.class, ()->studentManager.getStudentDetails(name1));
        assertDoesNotThrow(()->studentManager.recordGrade(name1, 3.0));
        assertDoesNotThrow(()->studentManager.getStudentDetails(name1));
    }
}
