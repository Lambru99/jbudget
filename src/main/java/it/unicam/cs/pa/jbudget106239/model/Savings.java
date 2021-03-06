/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini for the PA1920 project, it is strictly forbidden to use this program for profit, but it can be redistributed for free in an updated version. If redistributed, the program must have the same copyright and Ludovico Latini must be mentioned.
 */

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.unicam.cs.pa.jbudget106239.model;

import java.io.*;

/**
 * Questa classe permette di creare una cassa che memorizza i soldi dell'untente ed implementa i
 * metodi per sottrarre e aggiungere i soldi.
 */
public class Savings implements SavingsInterface {
    String text;
    double bank=0.0;
    ReadAndWrite readerAndWriter= new ReadAndWrite();
/**
 * @return bank
 * Con questo metodo ritorno la cassa che se non esisteva prende il valore 0.0 altrimenti prende il valore
 * letto nel file bank.txt
 */
    public double getBank() throws IOException, SignException {
        File file = new File(Account.path+File.separator+"bank.txt");
        if (!file.exists()){
        file.createNewFile();
        readerAndWriter.writeToFile(Account.path+File.separator+"bank",0.0);
        setBank(0.0);
        }
        double FileMoney = readerAndWriter.readToFile(Account.path+File.separator+"bank");
        setBank(FileMoney);
        return this.bank;
    }

    public void setBank(double bank) throws SignException {
        if (bank<0){
            throw new SignException(bank);
        }
        this.bank = bank;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * Con questo metodo aggiungo soldi sia alla variabile bank sia al file di testo bank.txt
     * richiamo poi i medoti contenuti nella classe PositiveReport per far si che text sia salvato nel
     * report positivo
     * @param money i soldi d'aggiungere
     * @param text la motivazione
     */
    @Override
    public void addMoney(double money,String text) throws IOException, SignException {
        if (money<0){
            throw new SignException(money);
        }
            File ReportFile = new File(Account.path+File.separator+"bank.txt");
            if (!ReportFile.exists()) {
                ReportFile.createNewFile();
                readerAndWriter.writeToFile(Account.path+File.separator+"bank",getBank());
            }
            double FileMoney = readerAndWriter.readToFile(Account.path+File.separator+"bank");
            FileMoney += money;
            setBank(FileMoney);
            readerAndWriter.writeToFile(Account.path+File.separator+"bank",FileMoney);
            PositiveReport positive = new PositiveReport();
            positive.writeOnReport(text,money);
    }
    public void addMoney(double money) throws IOException, SignException {
        File file = new File(Account.path+File.separator+"bank.txt");
        if(!file.exists()){
            throw new FileNotFoundException("File inesistente");

        }else {
                double var =readerAndWriter.readToFile(Account.path+File.separator+"bank");
                var = money+var;
                setBank(var);
                readerAndWriter.writeToFile(Account.path+File.separator+"bank",var);
        }
    }
    /**
     * Questo metodo sottrae soldi dalla variabile bank e riscrive bank.txt poi richiama come addMoney
     * i metodi della classe NegativeReport
     * @param money soldi da aggiungere
     * @param text una motivazione per il report
     */
    @Override
    public void subMoney(double money,String text) throws IOException, SignException {
      if (money<0){
          throw new SignException(money);
      }
           File ReportFile = new File(Account.path+File.separator+"bank.txt");
           if (!ReportFile.exists()) {
               ReportFile.createNewFile();
               readerAndWriter.writeToFile(Account.path+File.separator+"bank",getBank());
           }
           double FileMoney = readerAndWriter.readToFile(Account.path+File.separator+"bank");
           FileMoney -= money;
           setBank(FileMoney);
           readerAndWriter.writeToFile(Account.path+File.separator+"bank",FileMoney);
           NegativeReport negative = new NegativeReport();
           negative.writeOnReport(text, money);
    }
    public void subMoney(double money) throws SignException, IOException, BankException {
        File file = new File(Account.path+File.separator+"bank.txt");
        if(!file.exists()){
            throw new FileNotFoundException("File non trovato");

        }else {
                double var =readerAndWriter.readToFile(Account.path+File.separator+"bank");
                var = var - money;
                if (var<0){
                    throw new BankException();
                }else {
                    setBank(var);
                    readerAndWriter.writeToFile(Account.path + File.separator + "bank", var);
                }
        }
    }
}
