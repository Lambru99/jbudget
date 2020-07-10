/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini for the PA1920 project, it is strictly forbidden to use this program for profit, but it can be redistributed for free in an updated version. If redistributed, the program must have the same copyright and Ludovico Latini must be mentioned.
 */

package it.unicam.cs.pa.jbudget106239.view.javafx;

import it.unicam.cs.pa.jbudget106239.controller.Menu;
import it.unicam.cs.pa.jbudget106239.model.DelException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Controller che permette di visualizzare una pagina per l'eliminazione di un account
 */
public class DelAccount implements DelAccountInterface{
    Menu controller = new Menu();
   @FXML
   Label Error;
    @FXML
    TextField textDel;
    @FXML
    Button ButtonGo;
public String getAccount(){
    return textDel.getText();
}

    /**
     * Metodo che permette di eliminare un account
     */
    public void deleteAccount(){
    try {
        controller.delAccount(getAccount());
    } catch (IOException | DelException e) {
        Error.setText("Errore! Non posso eliminare questo account");
    }
    closeButtonAction();
}
    public void closeButtonAction(){
        Stage stage = (Stage) ButtonGo.getScene().getWindow();
        stage.close();
    }
}
