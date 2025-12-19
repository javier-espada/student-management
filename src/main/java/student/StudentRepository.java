package student;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.*;

public class StudentRepository {
    private static final String FILE_NAME = "data/students.json";
    private final Gson gson;

    public StudentRepository() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();

        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public void save(Map<String, IStudent> students) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(students.values(), writer);
        } catch (Exception e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    public Map<String, IStudent> load() {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            return new HashMap<>();
        }

        try (Reader reader = new FileReader(file)) {
            Student[] studentArray = gson.fromJson(reader, Student[].class);
            Map<String, IStudent> map = new HashMap<>();
            if (studentArray != null) {
                for (Student s : studentArray) {
                    map.put(s.getName().toUpperCase(), s);
                }
            }
            System.out.println("Data loaded");
            return map;

        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
            return new HashMap<>();
        }
    }
}