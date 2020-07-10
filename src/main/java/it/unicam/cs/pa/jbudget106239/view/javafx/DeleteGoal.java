/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini for the PA1920 project, it is strictly forbidden to use this program for profit, but it can be redistributed for free in an updated version. If redistributed, the program must have the same copyright and Ludovico Latini must be mentioned.
 */

package it.unicam.cs.pa.jbudget106239.view.javafx;

import it.unicam.cs.pa.jbudget106239.controller.Menu;
import it.unicam.cs.pa.jbudget106239.model.DelException;
import it.unicam.cs.pa.jbudget106239.model.SignException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller che permette di visualizzare una pagina per l'eliminazione di un goal
 */
public class DeleteGoal implements DelGoalInterface{
   Menu controller = new Menu();
   @FXML
   Label Error;
   @FXML
    Button DeleteGoalButton;
    @FXML
    TextField GoalNameToDelete;

    /**
     * Metodo che permette di eliminare un obiettivo
     */
    public void deleteGoal() {
        try {
            controller.deleteGoal(GoalNameToDelete.getText());
        } catch (SignException | DelException | IOException e) {
            Error.setText("Errore! Non posso eliminare questo obiettivo");
        }
        Stage stage = (Stage) DeleteGoalButton.getScene().getWindow();
        stage.close();
    }
}
