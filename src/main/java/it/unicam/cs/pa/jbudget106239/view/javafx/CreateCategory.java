/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini for the PA1920 project, it is strictly forbidden to use this program for profit, but it can be redistributed for free in an updated version. If redistributed, the program must have the same copyright and Ludovico Latini must be mentioned.
 */

package it.unicam.cs.pa.jbudget106239.view.javafx;


import it.unicam.cs.pa.jbudget106239.controller.Menu;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller che permette di visualizzare la pagina per la creazione di una categoria
 */
public class CreateCategory implements CreateCategoryInterface{
    Menu controller = new Menu();
    @FXML
    Label Error;
    @FXML
    Button CreateButton;
    @FXML
    TextField NameCategory;

    /**
     * Metodo per creare una categoria
     */
    public void newCategory() {
        try {
            controller.AddCategory(NameCategory.getText());
        } catch (IOException e) {
            Error.setText("Errore! Non posso creare la categoria");
        }
        Stage stage = (Stage) CreateButton.getScene().getWindow();
        stage.close();
    }
}
