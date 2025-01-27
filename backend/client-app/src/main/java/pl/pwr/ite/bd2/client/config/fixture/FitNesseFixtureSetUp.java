package pl.pwr.ite.bd2.client.config.fixture;


import com.google.common.collect.Lists;
import fit.Fixture;
import pl.pwr.ite.bd2.client.web.controller.TestowaAplikacja;
import pl.pwr.ite.bd2.model.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class FitNesseFixtureSetUp extends Fixture {

    static TestowaAplikacja testowaAplikacja;

    public FitNesseFixtureSetUp() {
        testowaAplikacja = new TestowaAplikacja();
        var student1 = new TestowaAplikacja.Student("Test", "Name", new ArrayList<>() {{
                add(createGrade(3.5f, 2f));
                add(createGrade(5f, 1f));
        }});
        var student2 = new TestowaAplikacja.Student("Test2", "Name2", new ArrayList<>() {{
                add(createGrade(4.0f, 2.0f));
                add(createGrade(3.0f, 2.0f));
        }});
        var student3 = new TestowaAplikacja.Student("Test3", "Name3", new ArrayList<>());

        testowaAplikacja.getStudents().add(student1);
        testowaAplikacja.getStudents().add(student2);
        testowaAplikacja.getStudents().add(student3);
    }

    public TestowaAplikacja.Grade createGrade(Float value, Float weight) {
        return new TestowaAplikacja.Grade(value, weight);
    }
}
