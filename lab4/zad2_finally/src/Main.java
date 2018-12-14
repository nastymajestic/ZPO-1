import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ReadFile read = new ReadFile();
        String json = read.read();

        Gson gson = new Gson();


        Type hasMapType = new TypeToken<HashMap<String, List<String>>>() {}.getType();



        Map<String, List<String>> hmapPolEng = new HashMap<String, List<String>>();

        hmapPolEng = gson.fromJson(json, hasMapType);
        System.out.println(hmapPolEng);                                 // wypisywanie hashMapy

        Set<String> key = hmapPolEng.keySet(); // tu mamy magiczne klucze po polsku

        System.out.println(key);
        String[] tablicaStringow = new String[15];
        key.toArray(tablicaStringow);
        List<String> listKey = new ArrayList<>();
       // System.out.println(listKey);

        for (int i = 0; i < tablicaStringow.length; i++) {
            listKey.add(tablicaStringow[i]);
        }
        //System.out.println(listKey);

        Random draw = new Random();
        Scanner in = new Scanner(System.in);

        Map<String, String> qa = new LinkedHashMap<>();
        int HowManyDraw = 15;
        double HowManyGoodAnswers = 0.0;

        JFrame frame = new JFrame("VocabTest");
        String imie = JOptionPane.showInputDialog(
                frame,
                "Wpisz imie ",
                "VocabTest",
                JOptionPane.WARNING_MESSAGE
        );
        JFrame frame2 = new JFrame("VocabTest");
        String nazwisko = JOptionPane.showInputDialog(
                frame2,
                "Wpisz nazwisko ",
                "VocabTest",
                JOptionPane.WARNING_MESSAGE
        );



        long startTime = System.nanoTime();

        for (int i = 0; i < 5; i++) {
            int index = draw.nextInt(HowManyDraw);
//            JFrame frame3 = new JFrame("VocabTest");
            String answer = JOptionPane.showInputDialog(
                    frame,
                    "podaj ang tlumaczenie slowa   "+listKey.get(index),
                    "VocabTest",
                    JOptionPane.WARNING_MESSAGE
            );


            qa.put(listKey.get(index), answer);
            answer = answer.toLowerCase();

            for (String translate : hmapPolEng.get(listKey.get(index))) {
                if (answer.equals(translate))
                    HowManyGoodAnswers += 1;
                if(Levenstein.computeLevenshteinDistance(translate, answer) == 1)
                    HowManyGoodAnswers += 0.5;
            }


            listKey.remove(index);
            HowManyDraw -= 1;
        }

        long endTime = System.nanoTime() - startTime;
        double endTimeSec = (double) endTime / 1000000000;

        Type qaType = new TypeToken<HashMap<String, String>>() {}.getType();
        String qaJson = gson.toJson(qa, qaType);

        WriteFile write = new WriteFile();
        System.out.println();
        write.write(qaJson, imie, nazwisko);


        JOptionPane.showMessageDialog(null, "Liczba poprawnych odp "+HowManyGoodAnswers, "Wyniki" + null, JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, String.format("Czas testu: %.2f", endTimeSec), "Wyniki" + null, JOptionPane.INFORMATION_MESSAGE);
//

        in.close();
    }
}