package it.unicam.cs.pa.jbudget106239;

import it.unicam.cs.pa.jbudget106239.model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SavingsTest {
    Account account = new Account();
    Savings savings = new Savings();
    @Test
    void setBank() throws IOException, SignException, DelException {
        account.newAccount("newTest",20);
        account.setPath("newTest");
        savings.setBank(20);
        assertEquals(20, savings.getBank());
        account.deleteAccount("newTest");
    }

    @Test
    void addMoney() throws IOException, SignException, DelException {
        account.newAccount("test2",20);
        account.setPath("test2");
        savings.addMoney(10);
        assertEquals(30, savings.getBank());
        account.deleteAccount("test2");

    }

    @Test
    void subMoney() throws IOException, SignException, DelException, BankException {
        account.newAccount("test3",20);
        account.setPath("test3");
        savings.subMoney(10);
        assertEquals(10, savings.getBank());
        account.deleteAccount("test3");
    }

}