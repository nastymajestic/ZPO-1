package sample;
import java.util.*;



public class Levenstein {
    public static Integer time = 0;
    private static int  currentVar = 0;
    public static Timer timer = new Timer();

    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int computeLevenshteinDistance(CharSequence lhs, CharSequence rhs) {
        int[][] distance = new int[lhs.length() + 1][rhs.length() + 1];

        for (int i = 0; i <= lhs.length(); i++)
            distance[i][0] = i;
        for (int j = 1; j <= rhs.length(); j++)
            distance[0][j] = j;

        for (int i = 1; i <= lhs.length(); i++)
            for (int j = 1; j <= rhs.length(); j++)
                distance[i][j] = minimum(
                        distance[i - 1][j] + 1,
                        distance[i][j - 1] + 1,
                        distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1));

        return distance[lhs.length()][rhs.length()];
    }


    public static void dupa() {




       /* private static final Type REVIEW_TYPE = new TypeToken<List<Review>>() {
        }.getType();
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(filename));
        List<Review> data = gson.fromJson(reader, REVIEW_TYPE); // contains the whole reviews list
        data.toScreen(); // prints to screen some values
        */


        String wika = "wika";
        String kupa = "dupa";
        //String helper =(String)ReadFile.read();
        int howlong = 0;
        howlong = computeLevenshteinDistance(wika,kupa);
        System.out.println(howlong);


       // System.out.println(json);
    }
}
