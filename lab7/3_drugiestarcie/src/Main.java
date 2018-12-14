import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) throws IOException {
//        Integer N = 1000;
//        Double srednia = 4.4;
//        Double odchylenieStd = -1.2;
        Integer N = Integer.valueOf(args[0]);
        Double srednia = Double.valueOf(args[1]);
        Double odchylenieStd = Double.valueOf(args[2]);
        assert odchylenieStd>0 : "odchylennie std nie moze byc mniejsze od zera";
        // tworzenie pliku binarnego          https://www.java-examples.com/write-float-file-using-dataoutputstream
        try {
            System.out.println("N =" + N+"srednia"+srednia+"odchylenie"+odchylenieStd);
            FileOutputStream fos = new FileOutputStream("zapisbinarny.txt");
            DataOutputStream dos = new DataOutputStream(fos);
            double[] buffer = new double[N];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = random.nextGaussian() * odchylenieStd + srednia;
                dos.writeDouble(buffer[i]);
            }
            dos.close();
        }catch (IOException e){
            System.out.println("IOException : " + e);
        }

        // odczytywanie pliku binarnego
        try {
            NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());  //https://www.geeksforgeeks.org/numberformat-class-java/
            FileInputStream fis = new FileInputStream("zapisbinarny.txt");
            DataInputStream dis = new DataInputStream(fis);
            FileOutputStream fos = new FileOutputStream("liczby.txt");
            PrintWriter printWriter = new PrintWriter(fos);


            while(dis.available()>0){
                Double temp = dis.readDouble();
                printWriter.println(nf.format(temp));

            }
            dis.close();
            printWriter.close();
        }catch (IOException e2){
            System.out.println("IOException : " + e2);
        }catch (NumberFormatException e3){
            System.out.println("IOException : " + e3);
        }


    }
}
