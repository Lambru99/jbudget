/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini for the PA1920 project, it is strictly forbidden to use this program for profit, but it can be redistributed for free in an updated version. If redistributed, the program must have the same copyright and Ludovico Latini must be mentioned.
 */

package it.unicam.cs.pa.jbudget106239.view.javafx;

import java.io.IOException;

/**
 * Interfaccia che viene implementata dalla classe AccountView
 *
 */
public interface AccountViewInterface {
    String getAccount();
    void selAccount() throws IOException;
    void closeButtonAction();
    void createNewAccount() throws IOException;
    void deleteAccount() throws IOException;
    void showAccount();
}
