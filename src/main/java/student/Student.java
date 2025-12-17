package student;

import java.util.ArrayList;
import java.util.List;

public class Student implements IStudent {
    private String name;
    private List<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Double> getGrades() {
        return grades;
    }
    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    @Override
    public double calculateAverage() {
        if (grades==null || grades.isEmpty()){
            // TODO: throws NoGradesException
        }
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum/grades.size();
    }

    @Override
    public boolean addGrade(double grade) {
        if (grade < 0.0 || grade > 10.0) {
            // TODO: throws InvalidGradeException
            return false;
        }

        grades.add(grade);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Student name: ").append(getName()).append("\n");
        sb.append("Grades: ").append(getGrades()).append("\n");
        sb.append("Average Grade: ").append(calculateAverage()).append("\n");

        return sb.toString();
    }

}