import java.util.Map;

public class Main {

    static int sposobA(Map<String, Integer> map, String word) {
                map.put(word, (map.containsKey(word)) ? map.get(word)+1 : 1);
        if(word == null){
            return 1;
        }
        return 0;
            }

            static int sposobB(Map<String, Integer> map, String word){
                map.put(word, (map.get(word) != null) ? map.get(word)+1 : 1);
                if(word == null){
                    return 1;
                }
                return 0;
            }

            static int sposobC(Map<String, Integer> map, String word)
            {
                if(word == null){
                    return 1;
                }
                map.put(word, map.getOrDefault(word, 0)+1);
                return 0;
            }

            static int sposobD(Map<String, Integer> map, String word)
            {
                Integer result = map.putIfAbsent(word, 1);
                if(result != null)
                    map.put(word, result+1);
                if(word == null){
                    return 1;
                }
                return 0;
            }


    public static void main(String[] args) {


    }
}


