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
 * Controller di una pagina che permette di creare un account
 */
public class CreateAccount implements CreateAccountInterface{
    Menu controller = new Menu();
    @FXML
    Label Error;
    @FXML
    TextField textNameAccount;
    @FXML
    TextField TextBudgetAccount;
    @FXML
    Button CreateNewAccount;


    /**
     * Metodo che permette di creare un account
     */
    public void createAccountNow()  {
        try {
            controller.createAccount(textNameAccount.getText(),Double.parseDouble(TextBudgetAccount.getText()));
        } catch (SignException | IOException e) {
            Error.setText("Errore! Inserisci un valore valido e positivo");
        }
        closeButtonAction();
    }
    public void closeButtonAction(){
        Stage stage = (Stage) CreateNewAccount.getScene().getWindow();
        stage.close();
    }
}
