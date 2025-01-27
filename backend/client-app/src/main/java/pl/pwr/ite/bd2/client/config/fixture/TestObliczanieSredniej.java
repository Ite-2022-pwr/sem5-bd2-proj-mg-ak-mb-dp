package pl.pwr.ite.bd2.client.config.fixture;

import fit.ColumnFixture;

import java.util.IllegalFormatCodePointException;

public class TestObliczanieSredniej extends ColumnFixture {
    String[] data;

    public Double countAverage() throws IllegalFormatCodePointException {
        try {
            return FitNesseFixtureSetUp.testowaAplikacja.calculateAverage(Integer.parseInt(data[0]));
        } catch (IllegalFormatCodePointException ex) {
            return 0.0d;
        }
    }
}
