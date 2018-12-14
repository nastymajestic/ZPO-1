import com.sun.istack.internal.NotNull;             // byl blad z tym od eclipsa

import java.util.ArrayList;

public class Main {

    public static int iterator;

    public static void main(String[] args) {
        try {
            ArrayList<String> list = cutStrings("Ala ma kota", 4);
            for (int i = 0; i < iterator; i++) {
                System.out.println(list.get(i));
            }

            list = cutStrings("abcd", 2);
            for (int i = 0; i < iterator; i++) {
                System.out.println(list.get(i));
            }
            list = cutStrings("", 3);
            for (int i = 0; i < iterator; i++) {
                System.out.println(list.get(i));
            }
            System.out.println("\n");
        }catch (NullPointerException | IllegalArgumentException e){
            System.out.println("Illegal argument exception length < 0 or s == null. ");
            e.printStackTrace();
        }


    }
    @NotNull
    static ArrayList cutStrings(String s, int length){


        if(s.length() % length == 0) {
            iterator = (s.length() / length);
        }
        else{
            iterator = (s.length() / length) + 1;
        }

        int k = 0;
        String []tempStringArray = new String[iterator];
        ArrayList<String> tempArray = new ArrayList<>(length);


        for(int i=0;k<iterator;k++){

            if(i+length>s.length()) {
                tempStringArray[k] = (s.substring(i));
            }
            else{
                tempStringArray[k] = (s.substring(i,i+length));
            }
            i += length;
            tempArray.add(tempStringArray[k]);
        }

        return tempArray;
    }
}


