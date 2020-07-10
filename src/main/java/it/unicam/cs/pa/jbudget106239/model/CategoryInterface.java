/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini for the PA1920 project, it is strictly forbidden to use this program for profit, but it can be redistributed for free in an updated version. If redistributed, the program must have the same copyright and Ludovico Latini must be mentioned.
 */

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.unicam.cs.pa.jbudget106239.model;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Permette di creare una categoria e chiede di implementare i metodi base per il controllo di essa
 */
public interface CategoryInterface {
     LinkedList<String> getCategoryReport(String name) throws IOException;
     void createCategory (String name) throws IOException;
     boolean del (String name) throws DelException, IOException;
     void subMoney(double money, String text, String name) throws SignException, IOException;
     void writeOnReport(double money, String report, String name) throws SignException, IOException;
}