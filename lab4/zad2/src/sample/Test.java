package sample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class Test {
    private static Random rnd = new Random();
    private static Scanner in = new Scanner(System.in);


    public static void runTest() {
        ReadFile read = new ReadFile();
        String json = read.read();

        Gson gson = new Gson();

        Type hMapType = new TypeToken<HashMap<String, List<String>>>() {}.getType();
        Map<String, List<String>> hmapPolEng = new HashMap<String, List<String>>();

        hmapPolEng = gson.fromJson(json, hMapType);
        System.out.println(hmapPolEng);

        Set<String> key = hmapPolEng.keySet();

        String[] tabKey = new String[15];                               // lista kluczy :) naszych polskich
        key.toArray(tabKey);
        List<String> listKey = new ArrayList<>();

        for (int i = 0; i < tabKey.length; i++) {
            listKey.add(tabKey[i]);
        }
        System.out.println(listKey);

        Map<String, String> qa = new LinkedHashMap<>();

        int maxWordsinList = 15;
        double goodAnswers = 0.0;
        // w tym miejscu powinna sie podmieniac makieta :/

        for(int i = 0; i < 5; i++){
            int index = rnd.nextInt(maxWordsinList);                  //losowanie z listy 15 slowek
            System.out.println("Podaj ang tlumaczenie slowa"+listKey.get(index));
            String answer = in.nextLine();

            qa.put(listKey.get(index),answer );
            answer = answer.toLowerCase();

            for(String translate:hmapPolEng.get(listKey.get(index))){
                if(answer.equals(translate)){
                    goodAnswers++;
                }
                if(Levenstein.computeLevenshteinDistance(translate, answer)==1){
                    goodAnswers+=0.5;
                }
            }
            listKey.remove(index);
            maxWordsinList--;
        }
        Type qaType = new TypeToken<HashMap<String, String>>() {}.getType();
        String qaJson = gson.toJson(qa, qaType);

        WriteFile write = new WriteFile();
        System.out.println("Liczba poprawnych odpowiedzi: " + goodAnswers);
        in.close();
    }
}
