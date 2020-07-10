/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini
 *  for the PA1920 project, it is strictly forbidden to use this program for profit,
 * but it can be redistributed for free in an updated version. If redistributed, the
 * program must have the same copyright and Ludovico Latini must be mentioned.
 */

package it.unicam.cs.pa.jbudget106239.view.javafx;

import it.unicam.cs.pa.jbudget106239.controller.Menu;
import it.unicam.cs.pa.jbudget106239.model.SignException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Controller del file fxml MainView che stampa a video
 * una serie di menu per fare tutte le operazioni
 */
public class MainView implements MainViewInterface{
    Menu controller = new Menu();
    //Sezione cassa
    @FXML
    Label ErrorMoney;
    @FXML
    TextField NumberOfMoney;
    @FXML
    TextField Motivation;
    @FXML
    SplitMenuButton SetMoney;
    @FXML
    MenuItem Addmoney;
    @FXML
    MenuItem SubMoney;
    //Sezione generale in ogni pagina
    @FXML
    Button ButtonMoney;
    @FXML
    Label Money;
    @FXML
    Button Account;
    //Sezione Report
    @FXML
    Label ErrorReport;
    @FXML
    TextArea PrintReport;
    @FXML
    Button TotalReport;
    @FXML
    Button PositiveReport;
    @FXML
    Button NegativeReport;
    //Sezione category
    @FXML
    Button PrintCategory;
    @FXML
    TextArea PrintExCategory;
    @FXML
    Button CreateCategory;
    @FXML
    Button AddMuv;
    @FXML
    Button ShowCategory;
    @FXML
    Button DelCategory;
    //Sezione obiettivi
    @FXML
    TextArea GoalArea;
    @FXML
    Button PrintGoal;
    @FXML
    Button CreateGoal;
    @FXML
    Button AddBudget;
    @FXML
    Button SubBudget;
    @FXML
    Button Controll;
    @FXML
    Button DelGoal;
    //Bottoni generali

    /**
     * Metodo che permette di tornare indietro alla scelta degli account
     * @throws IOException se non è possibile creare la pagina
     */
    public void returnToAccount() throws IOException {
        CreateWindow.createWindow("AccountView");
        Stage st = (Stage) Account.getScene().getWindow();
        st.close();
        closeButtonAction();
    }
    public void closeButtonAction(){
        Stage stage = (Stage) Account.getScene().getWindow();
        stage.close();
    }

    /**
     * Metodo che stampa il numero di soldi gia presenti
     */
    public void showMoney(){
        ButtonMoney.setOpacity(0);
        try {
            Money.setText(String.valueOf(controller.getMoney()));
        } catch (IOException | SignException e) {
        System.err.println("Errore di IO ");
        }
    }
    //Bottoni soldi


    public void setMoney() {
    addMoney();
    }

    /**
     * Metodo che permette di creare una transizione positiva
     */
    public void addMoney(){
        try {
            controller.addMoney(Double.parseDouble(NumberOfMoney.getText()),Motivation.getText());
        } catch (IOException | SignException e) {
            ErrorMoney.setText("Errore! Inserire un valore valido e positivo");
        }catch (NumberFormatException n){
            ErrorMoney.setText("Errore! Il formato del numero deve essere : XXXX.XX");
        }
        showMoney();
    }

    /**
     * Metodo che permette di creare una transizione negativa
     */
    public void subMoney(){
        try {
            controller.decrementMoney(Double.parseDouble(NumberOfMoney.getText()),Motivation.getText());
        } catch (IOException | SignException e) {
            ErrorMoney.setText("Errore! Inserire un valore valido e positivo");
        }catch (NumberFormatException n){
            ErrorMoney.setText("Errore! Il formato del numero deve essere : XXXX.XX");
        }
        showMoney();
    }
    //Bottoni report

    /**
     * Metodo che permette di stampare il report totale
     */
    public void totalReport(){
        StringBuilder stringBuilder= new StringBuilder();
        PrintReport.clear();
       try {
           for (int i = 0; i < controller.printReport().size(); i++) {
               stringBuilder.append(controller.printReport().get(i));
           }
       }catch (IOException e ){
           ErrorReport.setText("Errore! Non posso stampare il report");
       }
        PrintReport.setText(stringBuilder.toString());
    }

    /**
     * Metodo che permette di stampare il report positivo
     */
    public void positiveReport() {
        StringBuilder stringBuilder= new StringBuilder();
        PrintReport.clear();
        try {
            for (int i = 0; i < controller.printPositiveReport().size(); i++) {
                stringBuilder.append(controller.printPositiveReport().get(i));
            }
        }catch (IOException e){
            ErrorReport.setText("Errore! Non posso stampare il report positivo");
        }
        PrintReport.setText(stringBuilder.toString());
    }

    /**
     * Metodo che permette di stampare il report negativo
     */
    public void negativeReport(){
        StringBuilder stringBuilder= new StringBuilder();
        PrintReport.clear();
        try {
            for (int i = 0; i < controller.printNegativeReport().size(); i++) {
                stringBuilder.append(controller.printNegativeReport().get(i));
            }
        }catch (IOException e ){
            ErrorReport.setText("Errore! Non posso stampare il report negativo");
        }
        PrintReport.setText(stringBuilder.toString());
    }
    //Bottoni categorie

    /**
     * Questo metodo permette di stampare le categorie gia create
     */
    public void printCategory(){
        StringBuilder stringBuilder= new StringBuilder();
        PrintExCategory.clear();
        try {
            for (int i = 0; i < controller.getCategory().size(); i++) {
                stringBuilder.append(controller.getCategory().get(i));
            }
        }catch (IOException e){
            PrintExCategory.setText("Errore! Non posso stampare le categorie");
        }
        PrintExCategory.setText(stringBuilder.toString());
    }
    /**
     * Metodo che permette di creare una categoria
     * @throws IOException se non è possibile creare la pagina
     */
    public void createCategory() throws IOException {
        CreateWindow.createWindow("CreateCategory");
        printCategory();
    }
    /**
     * Metodo che permette di aggiungere movimenti ad una categoria
     * @throws IOException se non è possibile creare la pagina
     */
    public void addMuv() throws IOException {
       CreateWindow.createWindow("AddToCategory");
        showMoney();
    }
    /**
     * Metodo che permette di stampare una categoria
     * @throws IOException se non è possibile creare la pagina
     */
    public void showCategory() throws IOException {
        CreateWindow.createWindow("PrintCategory");
    }
    /**
     * Metodo che permette di eliminare una categoria
     * @throws IOException se non è possibile creare la pagina
     */
    public void delCategory() throws IOException {
        CreateWindow.createWindow("DelCategory");
        printCategory();
    }
    //Bottoni obiettivo

    /**
     * Metodo che permette di stampare gli obiettivi gia creati
     */
    public void printGoal(){
        StringBuilder stringBuilder= new StringBuilder();
        GoalArea.clear();
        try {
            for (int i = 0; i < controller.getGoal().size(); i++) {
                stringBuilder.append(controller.getGoal().get(i));
            }
        }catch (IOException e){
            GoalArea.setText("Errore! Non posso stampare le categorie");
        }
        GoalArea.setText(stringBuilder.toString());
    }
    /**
     * Metodo che permette di creare un obiettivo
     * @throws IOException se non è possibile creare la pagina
     */
    public void createGoal() throws IOException {
        CreateWindow.createWindow("CreateGoal");
        printGoal();
    }
    /**
     * Metodo che permette di aggiunre budget ad un obiettivo
     * @throws IOException se non è possibile creare la pagina
     */
    public void addBudget() throws IOException {
        CreateWindow.createWindow("AddBudgetToGoal");
        showMoney();
    }
    /**
     * Metodo che permette di sottrarre budget ad un obiettivo
     * @throws IOException se non è possibile creare la pagina
     */
    public void subBudget() throws IOException {
        CreateWindow.createWindow("SubBudgetToGoal");
        showMoney();
    }
    /**
     * Metodo che permette di controllare un obiettivo
     * @throws IOException se non è possibile creare la pagina
     */
    public void control() throws IOException {
        CreateWindow.createWindow("CompareGoal");
    }
    /**
     * Metodo che permette di eliminare un obiettivo
     * @throws IOException se non è possibile creare la pagina
     */
    public void delGoal() throws IOException {
        CreateWindow.createWindow("DeleteGoal");
        showMoney();
        printGoal();
    }
}
