package sample;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    void write(String json, String imie, String nazwisko) {
        String nazwaPliku = imie + "_" + nazwisko + ".json";
        FileWriter fileWriter = null;

        try {
            try {
                fileWriter = new FileWriter(nazwaPliku);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileWriter.write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
