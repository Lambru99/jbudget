/*
 * Copyright (c) 2020.
 * All rights reserved to Ludovico Latini. Program written entirely by Ludovico Latini for the PA1920 project, it is strictly forbidden to use this program for profit, but it can be redistributed for free in an updated version. If redistributed, the program must have the same copyright and Ludovico Latini must be mentioned.
 */

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.unicam.cs.pa.jbudget106239.model;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Interfaccia che viene implementata ReadAndWrite
 */
public interface ReadAndWriteInterface {
    void writeToFile(String x, double y, String z) throws IOException;
    void writeToFile(String x, double y) throws IOException;
    void readToFile(String z, LinkedList k)throws IOException;
    double readToFile(String z)throws IOException;
    boolean deleteFile(String x) throws DelException;

}
