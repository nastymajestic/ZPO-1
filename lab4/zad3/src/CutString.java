import java.util.ArrayList;

public class CutString {
    public static int iterator;
    public static ArrayList cutStrings(String s, int length){


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
