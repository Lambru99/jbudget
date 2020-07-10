/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written
 * entirely by Ludovico Latini for the PA1920 project, it is
 * strictly forbidden to use this program for profit, but it can
 * be redistributed for free in an updated version. If redistributed,
 * the program must have the same copyright and Ludovico Latini must be mentioned.
 */

package it.unicam.cs.pa.jbudget106239.model;

/**
 * Errore personalizzato per la cancellazione di un file
 */
public class DelException extends Exception{
    /**
     * Errore personalizzato per i problemi di eliminazione file
     */
    public DelException(){
        super("Errore di cancellazione file");
    }
}
