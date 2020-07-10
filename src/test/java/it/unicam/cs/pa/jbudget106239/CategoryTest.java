package it.unicam.cs.pa.jbudget106239;

import it.unicam.cs.pa.jbudget106239.model.Account;
import it.unicam.cs.pa.jbudget106239.model.Category;
import it.unicam.cs.pa.jbudget106239.model.DelException;
import it.unicam.cs.pa.jbudget106239.model.SignException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    Category greport = new Category();
    Account account = new Account();

    @Test
    void getCategoryReport() throws IOException, SignException {
    account.newAccount("test",12);
    File file = new File("test/cane.txt");
    assertFalse(file.exists());
    account.setPath("test");
    greport.createCategory("cane");
    assertTrue(file.exists());
    }

    @Test
    void createCategory() throws IOException, SignException, DelException {
        account.newAccount("cattest",12);
        account.setPath("cattest");
        greport.createCategory("category");
        File file = new File("cattest/category.txt");
        assertTrue(file.exists());
        method();
    }
    public void method() throws IOException, DelException {
        account.deleteAccount("test");
        account.deleteAccount("cattest");
    }
}