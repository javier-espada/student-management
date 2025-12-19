package test;

import exception.InvalidGradeException;
import exception.NoGradesException;
import exception.InvalidStudentNameException;
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
        Student student = assertDoesNotThrow(() -> new Student(name1));
        assertNotNull(student);
        assertEquals(name1, student.getName());
        assertNotEquals(name2, student.getName());
        student.setName(name2);
        assertEquals(name2, student.getName());
    }

    @Test
    public void testStudentConstructorExceptions(){
        assertDoesNotThrow(() -> new Student("Juan"));
        assertThrows(InvalidStudentNameException.class, () -> new Student("Ju4n"),
                "Exception is not thrown for numbers");
        assertDoesNotThrow(() -> new Student("Jüana María Eñe"),
                "Exception is thrown for special letters like tildes or Ñ");
    }

    @Test
    public void testAverageGrades() {
        final String name1 = "Juan";
        Student student = assertDoesNotThrow(() -> new Student(name1));
        assertNotNull(student);
        assertDoesNotThrow(() -> student.addGrade(3.0));
        assertDoesNotThrow(() -> student.addGrade(4.0));
        Double avg = assertDoesNotThrow(student::calculateAverage);
        assertEquals(3.5, avg);
    }


    @Test
    public void testGetGrades() {
        final String name1 = "Juan";
        Student student = assertDoesNotThrow(() -> new Student(name1));
        assertNotNull(student);
        List<Double> grades = student.getGrades();
        assertEquals(0, grades.size());
        assertDoesNotThrow(() -> student.addGrade(3.0));
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
        Student student = assertDoesNotThrow(() -> new Student(name1));
        assertNotNull(student);
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
