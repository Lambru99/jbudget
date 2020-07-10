package it.unicam.cs.pa.jbudget106239;

import it.unicam.cs.pa.jbudget106239.model.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GoalTest {
    Account account = new Account();
    Goal goal = new Goal();
    @Test
    void createNewGoal() throws IOException, SignException {
        account.newAccount("test",20);
        account.setPath("test");
        goal.createNewGoal("goal",20);
        assertEquals(20, goal.getAim("goal"));
        File file = new File("test");
        assertTrue(file.isDirectory());
    }

    @Test
    void addMoney() throws IOException, SignException, BankException {
        account.newAccount("test2",20);
        account.setPath("test2");
        goal.createNewGoal("goal",20);
        goal.addMoney("goal",20);
        assertEquals(20,goal.getBudget("goal"));
    }

    @Test
    void subMoney() throws IOException, SignException, BankException {
        account.newAccount("test3",20);
        account.setPath("test3");
        goal.createNewGoal("goal",20);
        goal.addMoney("goal",20);
        goal.subMoney("goal",10);
        assertEquals(10,goal.getBudget("goal"));
    }

    @Test
    void control() throws IOException, SignException, DelException, BankException {
        account.newAccount("test4",20);
        account.setPath("test4");
        goal.createNewGoal("goal",20);
        goal.addMoney("goal",20);
        assertEquals("hai raggiunto il tuo obiettivo",goal.control("goal"));
        method();
    }
    void method () throws IOException, DelException {
        account.deleteAccount("test");
        account.deleteAccount("test2");
        account.deleteAccount("test3");
        account.deleteAccount("test4");
    }

}