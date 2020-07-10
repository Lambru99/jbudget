package it.unicam.cs.pa.jbudget106239;

import it.unicam.cs.pa.jbudget106239.model.DelException;
import it.unicam.cs.pa.jbudget106239.model.ReadAndWrite;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReaderAndWriterTest {
ReadAndWrite readerAndWriter = new ReadAndWrite();
    @Test
    void writeToFile() throws IOException {
    readerAndWriter.writeToFile("prova","ciao");
        File file = new File("prova.txt");
        assertTrue(file.exists());
        assertTrue(file.delete());
        readerAndWriter.writeToFile("prova",12);
        File file2 = new File("prova.txt");
        assertTrue(file2.exists());
        assertTrue(file2.delete());
    }

    @Test
    void readToFile() throws IOException {
        readerAndWriter.writeToFile("prova","12");
        File file = new File("prova.txt");
        assertTrue(file.exists());
       assertEquals(12,readerAndWriter.readToFile("prova"));
       assertTrue(file.delete());

    }

    @Test
    void deleteLine() throws IOException, DelException {
        readerAndWriter.writeToFile("prova","ciao\npippo\npluto");
        readerAndWriter.deleteLine("prova","pippo");
        File  file = new File("prova.txt");
        assertTrue(file.exists());
        assertTrue(file.delete());
    }

    @Test
    void delDir() throws IOException {
        File file = new File("prova");
        assertTrue(file.mkdir());
        File file2 =new File("prova/prova.txt");
        assertTrue(file2.createNewFile());
        readerAndWriter.delDir("prova");
    }

    @Test
    void deleteFile() throws IOException, DelException {
        File file = new File("test.txt");
        assertTrue(file.createNewFile());
        assertTrue(file.exists());
        assertThrows(DelException.class,()->readerAndWriter.deleteFile("cane.txt"));
        assertTrue(readerAndWriter.deleteFile("test"));
    }
}