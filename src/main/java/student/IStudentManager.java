package student;

import exception.*;
import java.util.List;
import java.util.Map;

public interface IStudentManager {

    void addStudent(String name) throws DuplicateStudentException;

    void recordGrade(String studentName, double grade) throws StudentNotFoundException, InvalidGradeException;

    String getStudentDetails(String studentName) throws StudentNotFoundException, NoGradesException;

    Map<String, Double> getHighPerformingStudents(double minGrade);
}