import javax.annotation.processing.SupportedSourceVersion;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static LinkedList<String> slowkaPamietane = new LinkedList<>();
    public static ArrayList<String> slowkaDoZapomnienia = new ArrayList<>();
    public static ArrayList<String> slowkaZapomniane = new ArrayList();
   public static ArrayList<String> doLosowaniaArray = new ArrayList<>();
    static int iloscDninauki = 10;
    static int iloscDniPoKtorychMozeszZapomniec = 3;
    static double prawdopodobienstwo = 0.5;   // p = 0.5
    private static Random rnd = new Random();
    static int index;
    public  static  ArrayList<String> slowkaDoLosowania = new ArrayList<>();
    public  static String[] helperArray = new String[2];
   // public static Map<String,Integer> kalendarzNauki = new HashMap<>(iloscDninauki);



    public static void main(String[] args) throws FileNotFoundException {
        try{
        FileReader fileReader = new FileReader("C:\\Users\\Wika\\Desktop\\SEM5\\ZPO\\lab5\\zad3\\1500.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String textLine;
        while ((textLine=bufferedReader.readLine())!=null) {
            doLosowaniaArray.add(textLine);
        }




        for(int i = 0;i<iloscDninauki;i++){

            if(slowkaPamietane.size()==iloscDniPoKtorychMozeszZapomniec*2){
                slowkaDoZapomnienia.add(slowkaPamietane.removeLast());
                slowkaDoZapomnienia.add(slowkaPamietane.removeLast());
                for(int k = 0; k<2;k++) {
                    double prawdopodobRandom = rnd.nextDouble();

                    if(prawdopodobRandom>prawdopodobienstwo) {
                        index = rnd.nextInt(slowkaDoZapomnienia.size());
                        slowkaZapomniane.add(slowkaDoZapomnienia.get(index));


                        slowkaDoZapomnienia.remove(index);

                    }
                }

            }

            for(int j=0;j<2;j++) {

                index = rnd.nextInt(doLosowaniaArray.size());
                slowkaPamietane.addFirst(doLosowaniaArray.get(index));

            }
            System.out.println("Day "+(i+1));
            System.out.println("New words  "+slowkaPamietane.get(0) + " " + slowkaPamietane.get(1));

            if(slowkaZapomniane.size()!=0) {
                System.out.println("Forgotten words:" + slowkaZapomniane);
            }else{
            System.out.println("Forgotten words:    "+"---");}
            ArrayList<String> temporary = new ArrayList<>();
            temporary.addAll(slowkaDoZapomnienia); // dodanie elementu zlozonosc O(1)
            temporary.addAll(slowkaPamietane);     // dodatnie elementow zlozosnosc O(1)


           // System.out.println(slowkaPamietane);
            //System.out.println(slowkaDoZapomnienia);
            System.out.println(temporary);
            System.out.println("\n");
            slowkaZapomniane.clear();
        }


        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
