package test;

import exception.DuplicateStudentException;
import exception.NoGradesException;
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
}
