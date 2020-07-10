package it.unicam.cs.pa.jbudget106239;

import it.unicam.cs.pa.jbudget106239.model.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PositiveReportTest {
    Account account = new Account();
    Savings savings = new Savings();
    NegativeReport report = new NegativeReport();
    @Test
    void getReport() throws IOException, SignException, DelException {
        account.newAccount("test",20);
        account.setPath("test");
        savings.addMoney(20,"frase");
        File file = new File("test/report.txt");
        assertTrue(file.exists());
        account.deleteAccount("test");
    }

    @Test
    void writeOnReport() throws IOException, SignException, DelException {
        account.newAccount("test2",20);
        account.setPath("test2");
        assertThrows(SignException.class,()->report.writeOnReport("text",-12));
        report.writeOnReport("text",12);
        File file = new File("test2/report.txt");
        assertTrue(file.exists());
        account.deleteAccount("test2");
    }

    @Test
    void del() throws IOException, SignException, DelException {
        account.newAccount("test3",20);
        account.setPath("test3");
        assertThrows(DelException.class,()-> report.del("name"));
        report.writeOnReport("text", 15);
        assertTrue( report.del("report") && report.del("negativereport"));
        account.deleteAccount("test3");
    }
}