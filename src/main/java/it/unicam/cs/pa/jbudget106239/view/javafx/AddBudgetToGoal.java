/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini for the PA1920 project, it is strictly forbidden to use this program for profit, but it can be redistributed for free in an updated version. If redistributed, the program must have the same copyright and Ludovico Latini must be mentioned.
 */

package it.unicam.cs.pa.jbudget106239.view.javafx;

import it.unicam.cs.pa.jbudget106239.controller.Menu;
import it.unicam.cs.pa.jbudget106239.model.BankException;
import it.unicam.cs.pa.jbudget106239.model.SignException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller del file fxml AddBudgetToGoal che stampa a video
 * una pagina per aggiungere del budget ad un obiettivo
 */
public class AddBudgetToGoal implements AddBudgetToGoalInterface{
    Menu controller = new Menu();
    @FXML
    Label Error;
    @FXML
    Button AddBudget;
    @FXML
    TextField Budget;
    @FXML
    TextField GoalNameToAdd;

    /**
     * Metodo onAction del bottone che permette di aggiungere un budget
     * ad un obiettivo
     */

    public void addBudget() {
        try {
            controller.addMoneyToGoal(GoalNameToAdd.getText(),Double.parseDouble(Budget.getText()));
            Stage stage = (Stage) AddBudget.getScene().getWindow();
            stage.close();
        } catch (IOException | SignException e) {
            Error.setText("Errore! inserisci valori validi e positivi");
        }catch (NumberFormatException n){
            Error.setText("Errore! Il formato del numero deve essere : XXXX.XX");
        } catch (BankException k) {
            Error.setText("Errore! Credito non sufficiente");
        }

    }
}
