package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    String read() {
        String json = null;
        BufferedReader fileReader = null;

        try {
            try {
                fileReader = new BufferedReader(new FileReader("C:\\Users\\Wika\\Desktop\\SEM5\\ZPO\\lab4\\zad2_1\\src\\sample\\Test.json"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                json = fileReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return json;
    }
}