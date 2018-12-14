package sample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class Test {
    private static Random rnd = new Random();
    public static void runTest(){
        int maxWordsinList = 15;
        ReadFile read = new ReadFile();
        String json = read.read();
        Gson gson = new Gson();
        Type hMapType = new TypeToken<HashMap<String, List<String>>>() {}.getType();
        Map<String, List<String>> hmapPolEng = new HashMap<String, List<String>>();
        hmapPolEng = gson.fromJson(json, hMapType);
        Set<String> key =hmapPolEng.keySet();
        String[] tabKey = new String[15];                               // lista kluczy :) naszych polskich :)
        key.toArray(tabKey);
        List<String> listKey = new ArrayList<>();

        for (int i = 0; i < tabKey.length; i++) {
            listKey.add(tabKey[i]);
        }





    }

}
