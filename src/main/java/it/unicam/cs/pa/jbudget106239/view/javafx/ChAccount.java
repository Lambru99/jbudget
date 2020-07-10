/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini for the PA1920 project, it is strictly forbidden to use this program for profit, but it can be redistributed for free in an updated version. If redistributed, the program must have the same copyright and Ludovico Latini must be mentioned.
 */

package it.unicam.cs.pa.jbudget106239.view.javafx;


import it.unicam.cs.pa.jbudget106239.controller.Menu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Controller del file fxml ChAccount che stampa a video
 * una pagina che permette di scegliere un account
 */
public class ChAccount implements ChAccountInterface{
    Menu controller = new Menu();
    @FXML
    TextField textAccount;
    @FXML
    Button goButtonChAccount;
    public String getAccount(){
    return textAccount.getText();
    }

    /**
     * Metodo che permette di aprire una pagina una volta aver scelto l'account
     * @throws IOException se non è possibile caricare la pagina
     */
    public void goChAccount() throws IOException {
        controller.selAccount(getAccount());
        Parent parentView = FXMLLoader.load(getClass().getResource("/MainView.fxml"));
        Scene scene2 = new Scene(parentView);
        Stage stage = new Stage();
        stage.setScene(scene2);
        stage.show();
        closeButtonAction();
    }

    /**
     * Chiede le pagine precedenti
     */
    public void closeButtonAction(){
        Stage stage = (Stage) goButtonChAccount.getScene().getWindow();
        stage.close();
    }
}
