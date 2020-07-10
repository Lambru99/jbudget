package it.unicam.cs.pa.jbudget106239;

import it.unicam.cs.pa.jbudget106239.model.Account;
import it.unicam.cs.pa.jbudget106239.model.DelException;
import it.unicam.cs.pa.jbudget106239.model.SignException;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
Account account = new Account();

    @Test
    void newAccount() throws SignException, IOException {
    assertThrows(SignException.class,()->account.newAccount("name",-12));
    account.newAccount("test",500);
    File file = new File("test");
    File file2 = new File("paths.txt");
    File file3 = new File("test/bank.txt");
    File file4 = new File("test.txt");
    File file5 = new File("bank.txt");
    assertTrue(file.isDirectory());
    assertTrue(file2.exists());
    assertTrue(file3.exists());
    assertFalse(file4.exists());
    assertFalse(file5.exists());
    }

    @Test
    void getListOfPath() throws IOException {
        LinkedList<String>k=new LinkedList<>();
        BufferedReader bufferedReader= new BufferedReader(new FileReader("paths.txt"));
        String text = null;
        while ((text = bufferedReader.readLine())!=null){
            k.addFirst("\n"+text);
        }
        bufferedReader.close();
        assertTrue(Objects.equals(account.getListOfPath(), k));
    }

    @Test
    void deleteAccount() throws IOException, DelException {
        account.deleteAccount("test");
        File file = new File("test");
        File file2 = new File("paths.txt");
        assertTrue(file2.exists());
        boolean bool = true;
        for(String s : account.getListOfPath()){
            if (s.equals("test")){
                bool=false;
            }
        }
        assertTrue(bool);
    }
}