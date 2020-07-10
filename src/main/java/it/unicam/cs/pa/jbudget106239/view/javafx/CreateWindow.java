/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini for the PA1920 project, it is strictly forbidden to use this program for profit, but it can be redistributed for free in an updated version. If redistributed, the program must have the same copyright and Ludovico Latini must be mentioned.
 */

package it.unicam.cs.pa.jbudget106239.view.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *Questa classe permette di creare una nuova finestra passandogli come nome il
 * nome del file fxml della finestra
 */
public class CreateWindow {
    /**
     * Metodo statico che permette di aprire una nuova finestra
     * @param x nome del file fxml della finestra da aprire
     * @throws IOException Eccezione standard
     */
    public static void createWindow(String x) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CreateWindow.class.getResource("/"+x+".fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("JBUDGET");
        Image ico = new Image("/Images/Icona.png");
        stage.getIcons().add(ico);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();
    }
}
