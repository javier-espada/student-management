package student;

import exception.InvalidGradeException;
import exception.NoGradesException;

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
    public double calculateAverage() throws NoGradesException {
        if (grades==null || grades.isEmpty()){
            throw new NoGradesException("No grades have been set for this student!");
        }
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }

        double average = sum / grades.size();

        return Math.round(average*100)/100.0;
    }

    @Override
    public boolean addGrade(double grade) throws InvalidGradeException {
        if (grade < 0.0 || grade > 10.0) {
            throw new InvalidGradeException("Grade out of range! Make sure grade is between 0.0 and 10.0");
        }

        double roundedGrade = (double) Math.round(grade * 100) / 100;

        grades.add(roundedGrade);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Student name: ").append(getName()).append("\n");
        sb.append("Grades: ").append(getGrades()).append("\n");
        try {
            sb.append("Average Grade: ").append(calculateAverage()).append("\n");
        } catch (NoGradesException e) {
            sb.append("Average Grade: ").append(e.getMessage()).append("\n");
        }

        return sb.toString();
    }

}