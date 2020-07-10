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
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Controller del file fxml AccountView che permette di stampare a video
 * il menu per la scelta, la creazione e l'eliminazione dell'account.
 */
public class AccountView implements AccountViewInterface {
    Menu controller = new Menu();
    @FXML
    Button ButtonAccount;
    @FXML
    TextArea PrintAccount;
    @FXML
    Button SelectionAccount;
    @FXML
    Button NewAccount;
    @FXML
    Button DelAccount;

    /**
     * Permette di stampare gli account gia creati
     * @return una stringa con gli account
     */
    public String getAccount(){
        return controller.getAccount().toString();
    }

    /**
     * Crea la finestra per la selezione degli account
     * @throws IOException se non è possibile creare la pagina
     */
    public void selAccount() throws IOException {
        CreateWindow.createWindow("ChAccount");
        closeButtonAction();
    }

    /**
     * Metodo che permette di chiudere le finestre
     */
    public void closeButtonAction(){
        Stage stage = (Stage) SelectionAccount.getScene().getWindow();
        stage.close();
    }
    /**
     * Crea la finestra per la creazione degli account
     * @throws IOException se non è possibile creare la pagina
     */
    public void createNewAccount() throws IOException {
        CreateWindow.createWindow("CreateAccount");
        showAccount();

    }
    /**
     * Crea la finestra per l'eliminazione degli account
     * @throws IOException se non è possibile creare la pagina
     */
    public void deleteAccount() throws IOException {
        CreateWindow.createWindow("DelAccount");
        showAccount();
    }

    /**
     * Stampa gli acoount esistenti
     */
    public void showAccount() {
        PrintAccount.clear();
        StringBuilder stringBuilder= new StringBuilder();
        int k = controller.getAccount().size();
        for (int i =0; i<k;i++){
            stringBuilder.append(controller.getAccount().get(i));
        }
        PrintAccount.setText(stringBuilder.toString());
    }
}
