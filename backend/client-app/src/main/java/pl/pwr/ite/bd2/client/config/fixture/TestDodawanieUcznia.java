package pl.pwr.ite.bd2.client.config.fixture;

import fit.ColumnFixture;

import java.util.IllegalFormatCodePointException;

public class TestDodawanieUcznia extends ColumnFixture {
    String[] data;

    public boolean addStudent() throws IllegalFormatCodePointException {
        int initialStudents = countStudents();
        try {
            FitNesseFixtureSetUp.testowaAplikacja.addStudent(data[0], data[1]);
            int studentsAmount = countStudents();
            return studentsAmount != initialStudents;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public int countStudents() {
        return FitNesseFixtureSetUp.testowaAplikacja.getStudents().size();
    }
}
