package test;

import exception.DuplicateStudentException;
import exception.NoGradesException;
import exception.StudentNotFoundException;
import org.junit.jupiter.api.Test;
import student.Student;
import student.StudentManager;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestStudentManager {
    @Test
    public void testAddStudent() {
        final String name1 = "Juan";
        final String name2 = "Jüana María Eñe";
        final String name3 = "Ju4n";
        StudentManager studentManager = new StudentManager();
        assertThrows(InvalidStudentNameException, studentManager.addStudent(name3));
        assertDoesNotThrow(() -> studentManager.addStudent(name1));
        assertDoesNotThrow(() -> studentManager.addStudent(name2));
        assertThrows(DuplicateStudentException.class, () -> studentManager.addStudent(name1));
    }

    @Test
    public void testRecordGrade() {
        final String name1 = "Juan";
        StudentManager studentManager = new StudentManager();
        assertDoesNotThrow(() -> studentManager.addStudent(name1));
        assertThrows(NoGradesException.class, () -> studentManager.getStudentDetails(name1));
        assertDoesNotThrow(() -> studentManager.recordGrade(name1, 3.0));
        assertDoesNotThrow(() -> studentManager.getStudentDetails(name1));
    }

    @Test
    public void testGetStudentDetails() {
        final String name1 = "Juan";
        StudentManager studentManager = new StudentManager();
        assertThrows(StudentNotFoundException.class, () -> studentManager.getStudentDetails(name1));
        assertDoesNotThrow(() -> studentManager.addStudent(name1));
        assertThrows(StudentNotFoundException.class, () -> studentManager.getStudentDetails("Paco"));
        assertThrows(NoGradesException.class, () -> studentManager.getStudentDetails(name1));
        assertDoesNotThrow(() -> studentManager.recordGrade(name1, 3.0));
        assertDoesNotThrow(() -> studentManager.getStudentDetails(name1));
    }

    @Test
    public void testGetHighPerformingStudents() {
        final String name1 = "Juan";
        final String name2 = "María";
        final String name3 = "Paco";
        StudentManager studentManager = new StudentManager();
        assertDoesNotThrow(() -> {
            studentManager.addStudent(name1);
            studentManager.addStudent(name2);
            studentManager.addStudent(name3);

            studentManager.recordGrade(name1, 5.0);
            studentManager.recordGrade(name1, 10.0);
            studentManager.recordGrade(name1, 8.0);

            studentManager.recordGrade(name2, 5.0);
            studentManager.recordGrade(name2, 4.5);
            studentManager.recordGrade(name2, 7.0);

            studentManager.recordGrade(name3, 6.5);
            studentManager.recordGrade(name3, 9.7);
            studentManager.recordGrade(name3, 8.0);

            Map<String, Double> map = studentManager.getHighPerformingStudents(7.0);
            assertTrue(map.containsKey(name1.toUpperCase()));
            assertFalse(map.containsKey(name2.toUpperCase()));
            assertTrue(map.containsKey(name3.toUpperCase()));
        });
    }
}