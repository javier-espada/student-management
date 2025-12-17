package student;
import java.util.List;

public interface IStudent {
    String getName();
    List<Double> getGrades();

    double calculateAverage();
    boolean addGrade(double grade);

}
