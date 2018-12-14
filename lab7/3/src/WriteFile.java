import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
    public static void writeFunctionByte(byte[] buffor){
        try {

            FileOutputStream fos = new FileOutputStream("data.txt");
            fos.write(buffor);
            fos.flush();
            fos.close();
        }catch (IOException e){
            System.out.println("Nie udalo sie stworzyc pliku");
        }

    }
    public static void writeFunctionNumberByNumber(int temp){
        try {
            //String xd = String.valueOf(temp);
            String xd = "dupa";
            byte[] content = xd.getBytes();
            FileOutputStream fos = new FileOutputStream("ciekawyplik.txt");
            fos.write(content);
            fos.flush();
            fos.close();
        }catch (IOException e){
            System.out.println("Nie udalo sie stworzyc pliku");
        }
    }
}
