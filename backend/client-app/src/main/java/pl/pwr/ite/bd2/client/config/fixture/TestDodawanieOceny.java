package pl.pwr.ite.bd2.client.config.fixture;

import fit.ColumnFixture;
import jakarta.persistence.Index;
import pl.pwr.ite.bd2.client.web.controller.TestowaAplikacja;

import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.Set;

public class TestDodawanieOceny extends ColumnFixture {
    String[] data;

    public boolean addGrade() {
        int initialGrades = countGrades();
        var grade = new TestowaAplikacja.Grade(Float.valueOf(data[0]), Float.valueOf(data[1]));
        try {
            FitNesseFixtureSetUp.testowaAplikacja.addGrade(grade, Integer.parseInt(data[2]));
            return countGrades() != initialGrades;
        } catch (IndexOutOfBoundsException | IllegalArgumentException ex) {
            return false;
        }
    }

    public int countGrades() {
        try {
            return FitNesseFixtureSetUp.testowaAplikacja.getStudents().get(Integer.parseInt(data[2])).getGrades().size();
        } catch (IndexOutOfBoundsException ex) {
            return 0;
        }
    }
}
