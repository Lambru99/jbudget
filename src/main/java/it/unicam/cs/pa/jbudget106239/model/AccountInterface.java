/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini for the PA1920 project, it is strictly forbidden to use this program for profit, but it can be redistributed for free in an updated version. If redistributed, the program must have the same copyright and Ludovico Latini must be mentioned.
 */

package it.unicam.cs.pa.jbudget106239.model;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Interfaccia che viene estesa dalla classe Account
 */
public interface AccountInterface {
    LinkedList<String> getListOfPath();
    void setPath(String path);
    void newAccount(String name, double money) throws SignException, IOException;
    void deleteAccount(String x) throws IOException, DelException;
}
