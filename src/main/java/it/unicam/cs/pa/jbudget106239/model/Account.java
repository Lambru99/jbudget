/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini for the PA1920 project, it is strictly forbidden to use this program for profit, but it can be redistributed for free in an updated version. If redistributed, the program must have the same copyright and Ludovico Latini must be mentioned.
 */

package it.unicam.cs.pa.jbudget106239.model;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Questa classe permette di creare e gestire un account che potrà rappresentare un particolare conto
 */
public class Account implements AccountInterface{
    public static String path="";

    public void setListOfPath(LinkedList<String> listOfPath) {
        this.listOfPath = listOfPath;
    }

    private LinkedList<String> listOfPath = new LinkedList<>();
    ReadAndWrite readerAndWriter = new ReadAndWrite();

    /**
     * Restituisce una lista di account gia creati
     * @return una lista di accout
     */
    public LinkedList<String> getListOfPath() {
        LinkedList<String> llist = new LinkedList<>();
        try {
            readerAndWriter.readToFile("paths",llist);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setListOfPath(llist);
        return this.listOfPath;
    }


    /**
     * medoto che permette di settare il path
     * @param path il parametro da settare
     */
    public void setPath(String path) {
        Account.path = path;
    }


    /**
     * Costruttore della classe Account che permette di creare un nuovo account
     * @param name nome dell'account
     * @param money soldi iniziali
     */
    public void newAccount(String name, double money) throws SignException, IOException {
        PathAccount pathAccount=new PathAccount();
        if(money<0){
            throw new SignException(money);
        }
        pathAccount.createNewPhat(name);
        setPath(name);
        Savings mb = new Savings();
        mb.getBank();
        mb.addMoney(money);
        try {
            readerAndWriter.writeToFile(path+ File.separator+"category","");
            readerAndWriter.writeToFile(path+ File.separator+"goal","");
            readerAndWriter.writeToFile("paths",name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Metodo che permette di eliminare un account
     * @param x account da eliminare
     */
    public void deleteAccount(String x) throws IOException, DelException {
            readerAndWriter.delDir(x);
            readerAndWriter.deleteLine("paths",x);
    }
}
