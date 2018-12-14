import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class OpenFile extends  Exception {
    private static FileInputStream fis = null;
    public static ArrayList<Integer> openByteFileAndWriteLineByLine(){
        ArrayList<Integer> readedNumbers = new ArrayList<>();

        try {
            fis = new FileInputStream("data.txt");
        } catch (FileNotFoundException e) {
            System.out.println("BŁĄD!!! Nie znaleziono pliku...");
            System.exit(1);
        }
        int bajt = 0;
        try {
            bajt = fis.read();
            while(bajt != -1){ // wartość -1 zwracana gdy koniec pliku...
               // System.out.print((byte)bajt);
                readedNumbers.add(bajt);
                WriteFile.writeFunctionNumberByNumber(bajt);
                bajt = fis.read();


            }
        } catch (IOException e) {
            System.out.println("BŁĄD ODCZYTU!!!");
            System.exit(2);
        }
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readedNumbers;
    }

}

