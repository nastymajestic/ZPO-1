package lab4;
import java.lang.reflect.Array;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Main {
     public static Collator c = Collator.getInstance(Locale.getDefault());
     public static String[] fastSortStrings(Collator collator, String[] slowa){
         long time = System.nanoTime();
         Arrays.sort(slowa, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return c.compare(o1, o2);

            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
         System.out.println(System.nanoTime()-time);
        return slowa;
    }

    public static String[] fastSortStrings2(Collator collator, String[] slowa){
         long time = System.nanoTime();
        Arrays.sort(slowa,(o1,o2)->c.compare(o1, o2));
        System.out.println(System.nanoTime()-time);
        return slowa;
    }

    public static String[] sortStrings(Collator collator, String[] slowa){
        long time = System.nanoTime();
        String tmp;
        int i = 0;
        int j = 0;


        for (i = 0; i < slowa.length; i++){
            j = i;
            tmp=slowa[i];
            while (j > 0 && collator.compare(slowa[j-1], tmp) > 0){
                slowa[j] = slowa[j-1];
                j--;
            }

        }
        System.out.println(System.nanoTime()-time);
        return slowa;
    }








    public static void main(String[] args) {
        String slowa[]={
            "Łukasz", "Lucyna", "Marek"
        };
        String test1[] = fastSortStrings(c,slowa);
        String test2[]= fastSortStrings2(c,slowa );
        String test3[] = sortStrings(c,slowa );
        System.out.println(Arrays.deepToString(test1));
        System.out.println(Arrays.deepToString(test2));
        System.out.println(Arrays.deepToString(test3));





    }
}
