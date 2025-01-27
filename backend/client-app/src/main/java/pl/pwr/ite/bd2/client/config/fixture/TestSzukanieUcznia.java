package pl.pwr.ite.bd2.client.config.fixture;

import fit.ColumnFixture;

public class TestSzukanieUcznia extends ColumnFixture {
    String[] data;

    public boolean searchStudent() {
        try {
            return FitNesseFixtureSetUp.testowaAplikacja.findByFirstAndLastName(data[0], data[1]) != null;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
