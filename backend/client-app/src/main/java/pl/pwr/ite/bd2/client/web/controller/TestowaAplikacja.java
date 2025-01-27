package pl.pwr.ite.bd2.client.web.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TestowaAplikacja {

    private final List<Student> students = new ArrayList<>();


    public void addGrade(Grade grade, int studentIndex) throws IllegalArgumentException {
        Student student;
        try {
            student = students.get(studentIndex);
            student.getGrades().add(grade);
        } catch (IndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("Student doesn't exist");
        }
    }

    public Double calculateAverage(int studentIndex) {
        var student = students.get(studentIndex);
        if(student.getGrades().isEmpty()) {
            return 0.0d;
        }
        var sumOfGrades = student.getGrades().stream()
                .mapToDouble(grade -> grade.getValue() * grade.getWeight())
                .sum();
        var sumOfWeights = student.getGrades().stream()
                .mapToDouble(Grade::getWeight)
                .sum();

        return sumOfGrades / sumOfWeights;
    }

    public Student findByFirstAndLastName(String firstName, String lastName) {
        return students.stream().filter(s ->
                s.getFirstName().equalsIgnoreCase(firstName)
                        && s.getLastName().equalsIgnoreCase(lastName)
        ).findFirst().orElse(null);
    }

    public void addStudent(String firstName, String lastName) {
        if(findByFirstAndLastName(firstName, lastName) != null) {
            throw new IllegalArgumentException("Student already exists");
        }
        students.add(new Student(firstName, lastName, new ArrayList<>()));
    }

    @Data
    @AllArgsConstructor
    public static class Student {
        private String firstName;
        private String lastName;
        private List<Grade> grades;
    }
    @Data
    @AllArgsConstructor
    public static class Grade {
        private Float value;
        private Float weight;
    }
}


