/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini for the PA1920 project, it is strictly forbidden to use this program for profit, but it can be redistributed for free in an updated version. If redistributed, the program must have the same copyright and Ludovico Latini must be mentioned.
 */

package it.unicam.cs.pa.jbudget106239.view.javafx;


import it.unicam.cs.pa.jbudget106239.controller.Menu;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;

/**
 * Controller che permette di visualizzare la pagina per la stampa di una categoria
 */
public class PrintCategory implements PrintCategoryInterface{
    Menu controller = new Menu();
    @FXML
    Label Error;
    @FXML
    Button PrintButton;
    @FXML
    TextArea PrintCategoryArea;
    @FXML
    TextField NameOfCategory;

    /**
     * Metodo che permette di stampare una categoria
     */
    public void printCategory() {
        StringBuilder stringBuilder = new StringBuilder();
        PrintCategoryArea.clear();
        try {
            for (int i = 0; i < controller.printCategory(NameOfCategory.getText()).size(); i++) {
                stringBuilder.append(controller.printCategory(NameOfCategory.getText()).get(i));
            }
        }catch (IOException e){
            Error.setText("Errore! Non posso stampare questa categoria");
        }
        PrintCategoryArea.setText(stringBuilder.toString());
    }
}
