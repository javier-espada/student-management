package test;

import exception.InvalidGradeException;
import exception.NoGradesException;
import org.junit.jupiter.api.Test;
import student.Student;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestStudent {
    @Test
    public void testStudentConstructor() {
        final String name1 = "Juan";
        final String name2 = "Maria";
        Student student = new Student(name1);
        assertNotNull(student);
        assertEquals(name1, student.getName());
        assertNotEquals(name2, student.getName());
        student.setName(name2);
        assertEquals(name2, student.getName());
    }

    @Test
    public void testAverageGrades() {
        final String name1 = "Juan";
        Student student = new Student(name1);
        student.addGrade(3.0);
        student.addGrade(4.0);
        assertEquals(3.5, student.calculateAverage());
    }


    @Test
    public void testGetGrades() {
        final String name1 = "Juan";
        Student student = new Student(name1);
        List<Double> grades = student.getGrades();
        assertEquals(0, grades.size());
        student.addGrade(3.0);
        grades = student.getGrades();
        assertEquals(1, grades.size());
        List<Double> grades2 = new ArrayList<>();
        grades2.add(10.0);
        student.setGrades(grades2);
        assertEquals(10.0, student.getGrades().getFirst());
    }

    @Test
    public void testStudentGradeExceptions() {
        final String name1 = "Juan";
        Student student = new Student(name1);
        assertThrows(NoGradesException.class, student::calculateAverage);
        assertDoesNotThrow(() -> {
            student.addGrade(10.0);
        });
        assertDoesNotThrow(() -> {
            student.addGrade(0.0);
        });
        assertThrows(InvalidGradeException.class, () -> student.addGrade(-1.0));
        assertThrows(InvalidGradeException.class, () -> student.addGrade(12.0));
    }
}
