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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller che permette di visualizzare la pagina per la creazione di un obiettivo
 */
public class CreateGoal implements CreateGoalInterface{
    Menu controller = new Menu();
    @FXML
    Label Error;
    @FXML
    Button CreateGoal;
    @FXML
    TextField Aim;
    @FXML
    TextField GoalName;

    /**
     * Metodo per creare un obiettivo
     */
    public void createNewGoal() {
        try {
            controller.createGoal(GoalName.getText(),Double.parseDouble(Aim.getText()));
            Stage stage = (Stage) CreateGoal.getScene().getWindow();
            stage.close();
        } catch (IOException | SignException e) {
            Error.setText("Errore! Inserisci un valore valido e positivo");
        }catch (NumberFormatException n){
            Error.setText("Errore! Il formato del numero deve essere : XXXX.XX");
        }

    }
}
