/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini for the PA1920 project, it is strictly forbidden to use this program for profit, but it can be redistributed for free in an updated version. If redistributed, the program must have the same copyright and Ludovico Latini must be mentioned.
 */

package it.unicam.cs.pa.jbudget106239.view.javafx;

import it.unicam.cs.pa.jbudget106239.controller.Menu;
import it.unicam.cs.pa.jbudget106239.model.SignException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Controller di una pagina che permette il controllo di un obiettivo
 */
public class CompareGoal implements CompareGoalInterface {
   Menu controller = new Menu();
   @FXML
    TextArea PrintResult;
   @FXML
   Label Error;
   @FXML
    Button Compere;
    @FXML
    TextField GoalNameToCompare;

    public void compere() {
        try {
            PrintResult.setText(controller.compare(GoalNameToCompare.getText()));
        } catch (IOException | SignException e) {
            Error.setText("Errore! Non posso comparare questo obiettivo");
        }
    }
}
