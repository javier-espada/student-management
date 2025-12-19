package student;
import exception.InvalidGradeException;
import exception.NoGradesException;

import java.util.List;

public interface IStudent {
    String getName();
    List<Double> getGrades();

    double calculateAverage() throws NoGradesException;
    void addGrade(double grade) throws InvalidGradeException;

    String printStudent() throws NoGradesException;
}
