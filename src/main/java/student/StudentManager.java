package student;

import exception.*;
import java.util.HashMap;
import java.util.Map;

public class StudentManager implements IStudentManager {

    private final Map<String, IStudent> studentsList;
    private final StudentRepository repository;

    public StudentManager() {
        this.repository = new StudentRepository();
        Map<String, IStudent> loadedData = repository.load();
        this.studentsList = (loadedData != null) ? loadedData : new HashMap<>();
    }

    @Override
    public void addStudent(String name) throws DuplicateStudentException {
        if (studentsList.containsKey(name)) {
            throw new DuplicateStudentException(name);
        }
        studentsList.put(name, new Student(name));
        repository.save(studentsList);
    }

    @Override
    public void recordGrade(String studentName, double grade) throws StudentNotFoundException, InvalidGradeException {
        if (grade < 0 || grade > 10) {
            throw new InvalidGradeException(studentName);
        }

        IStudent student = studentsList.get(studentName);
        if (student == null) {
            throw new StudentNotFoundException(studentName);
        }

        student.addGrade(grade);
        repository.save(studentsList);
    }

    @Override
    public String getStudentDetails(String studentName) throws StudentNotFoundException, NoGradesException {
        IStudent student = studentsList.get(studentName);
        if (student == null) {
            throw new StudentNotFoundException(studentName);
        }

        double average = student.calculateAverage(); // noGradesException here
        return String.format("Student: %s | Grades: %s | Average: %.2f", student.getName(), student.getGrades().toString(), average);
    }

    @Override
    public Map<String, Double> getHighPerformingStudents(double minGrades) {

        Map<String, Double> highP = new HashMap<>();;
        for(String studentName : studentsList.keySet()) {
            IStudent student = studentsList.get(studentName);
            try {
                double avg = student.calculateAverage();

                if (avg >= minGrades) {
                    highP.put(studentName, avg);
                }
            } catch (NoGradesException e) {
                continue;
            }
        }
        return highP;
    }

    @Override
    public IStudent getStudent(String name) throws StudentNotFoundException {
        if (!studentsList.containsKey(name)) {
            throw new StudentNotFoundException(name);
        }
        return studentsList.get(name);
    }
}
