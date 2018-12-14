import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTesting {
    private String word = "Wika";
    private String word2 = null;
    @Test
    public void sposobA() throws Exception {
        Map<String, Integer> result = new HashMap<>();
        Main.sposobA(result, word2);
        Main.sposobA(result, word2);
        Main.sposobA(result, word2);
        assertEquals(getCorrectMap(), result);
    }
    @Test
    public void sposobB() throws Exception {
        Map<String, Integer> result = new HashMap<>();
        Main.sposobB(result, word2);
        Main.sposobB(result, word2);
        Main.sposobB(result, word2);
        assertEquals(getCorrectMap(), result);
    }


    @Test
    public void sposobD() throws Exception {

        Map<String, Integer> result = new HashMap<>();
        Main.sposobB(result, word2);
        Main.sposobB(result, word2);
        Main.sposobB(result, word2);
         assertEquals(getCorrectMap(), result);

    }



    private Map<String, Integer> getCorrectMap()
    {
        Map<String, Integer> result = new HashMap<>();
        result.merge(word2, 1, Integer::sum);
        result.merge(word2, 1, Integer::sum);
        result.merge(word2, 1, Integer::sum);
        return result;
    }


}