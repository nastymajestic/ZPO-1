import java.util.HashMap;
import java.util.Map;

public class Levenshtein {

    public static HashMap<Character, Character[]> keybordPositions = getKeybordAssoc();

    public double LevQWERTY(String s1, String s2){
        double[][] d = new double[s1.length() + 1][s2.length() + 1];
        double cost;

        for (int i = 0; i < s1.length(); i++){
            d[i][0] = i;
        }

        for (int j = 1; j < s2.length(); j++){
            d[0][j] = j;
        }

        for (int currentCol = 1; currentCol <= s1.length(); currentCol++){
            for (int currentRow = 1; currentRow <= s2.length(); currentRow++){
                if(s1.charAt(currentCol - 1) == s2.charAt(currentRow - 1)){
                    cost = 0;
                } else if (isNeighbor(s1.charAt(currentCol - 1), s2.charAt(currentRow - 1))) {
                    cost = 0.5;
                } else {
                    cost = 1;
                }
                d[currentCol][currentRow] = Math.min(d[currentCol - 1][currentRow] +1, Math.min(d[currentCol][currentRow - 1] +1, d[currentCol - 1][currentRow - 1] + cost));
            }
        }

        return d[s1.length()][s2.length()];
    }

    private boolean isNeighbor(char c1, char c2){

        Character[] characters = keybordPositions.get(c1);

        for (Character c : characters){
            if(c == c2){
                return true;
            }
        }
        return false;
    }


}
