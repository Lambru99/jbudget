/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini for the PA1920 project, it is strictly forbidden to use this program for profit, but it can be redistributed for free in an updated version. If redistributed, the program must have the same copyright and Ludovico Latini must be mentioned.
 */

package it.unicam.cs.pa.jbudget106239.view.javafx;

import java.io.IOException;

/**
 * Interfaccia che viene implementata da MainView
 */
public interface MainViewInterface {
    //Sezione generale
    void returnToAccount() throws IOException;
    void closeButtonAction();
    void showMoney();
   //Sezione relativa ai movimenti
    void setMoney();
    void subMoney();
    //Sezione relativa ai report
    void totalReport();
    void positiveReport();
    void negativeReport();
    //Sezione relativa alle categorie
    void printCategory();
    void createCategory() throws IOException;
    void addMuv() throws IOException;
    void showCategory() throws IOException;
    void delCategory() throws IOException;
    //Sezione relative agli obiettivi
    void printGoal();
    void createGoal() throws IOException;
    void addBudget() throws IOException;
    void subBudget() throws IOException;
    void control() throws IOException;
    void delGoal() throws IOException;
}
