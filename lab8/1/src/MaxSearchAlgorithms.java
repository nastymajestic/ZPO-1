import java.util.ArrayList;

public class MaxSearchAlgorithms {

//    public static ArrayList<Integer> maxIntLeftToRightScan(int tab[]){
//        ArrayList<Integer> temporaryMaxValue = new ArrayList<>();
//        int maximum = tab[0];
//        temporaryMaxValue.add(maximum);
//        for(int i =0;i<tab.length;i++){
//            if(tab[i]>maximum){
//
//                maximum = tab[i];
//                temporaryMaxValue.add(maximum);
//            }
//
//        }
//        return temporaryMaxValue;
//    }

    public static ArrayList<Integer> maxIntRightToLeftScan(int tab[]){
        ArrayList<Integer> temporaryMaxValue = new ArrayList<>();
        int maximum = tab[tab.length-1];
        temporaryMaxValue.add(maximum);
        for(int i = tab.length-1;i>=0;i--){
            if(tab[i]>maximum){

                maximum = tab[i];
                temporaryMaxValue.add(maximum);
            }

        }
        return temporaryMaxValue;
    }
    public static ArrayList<Integer> maxIntEvenOddIndexScan(int tab[]) {
        ArrayList<Integer> temporaryMaxValue = new ArrayList<>();
        int maximum = tab[0];
        temporaryMaxValue.add(maximum);
        for (int i = 0; i < tab.length; i += 2) {
            if (maximum < tab[i]) {
                temporaryMaxValue.add(tab[i]);
                maximum = tab[i];
            }
        }
        for (int i = 1; i < tab.length; i += 2) {
            if (maximum < tab[i]) {
                temporaryMaxValue.add(tab[i]);
                maximum = tab[i];
            }
        }
    return temporaryMaxValue;
    }
    public static void withoutSccan(){

    }
}
