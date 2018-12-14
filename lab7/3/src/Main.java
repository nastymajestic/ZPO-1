import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {


    private static Random random = new Random();

    public static void main(String[] args) throws IOException {


        // pamietaj o zamianie na przecinek
        ArrayList<Integer> xd = new ArrayList<>();
        Integer N = 5;
        Double srednia = 4.4;
        Double odchylenieStd = (-1.2);

        byte[] buffor = new byte[N];
        if(odchylenieStd<0) {
            //System.out.println("odchylennie std nie moze byc mniejsze od zera");
            throw new AssertionError();
        }
            assert odchylenieStd < 0 : "odchylennie std nie moze byc mniejsze od zera";

            for(int i = 0;i<buffor.length;i++){
                buffor[i] = (byte) (random.nextGaussian()*odchylenieStd+srednia);
                System.out.println(buffor[i]);
            }

            WriteFile.writeFunctionByte(buffor);  // zaapisywanie do pliku <byte>
            xd =OpenFile.openByteFileAndWriteLineByLine();//odczytywanie pliku tego z byte i zapisywanie lade
        System.out.println(xd);


    }
}
