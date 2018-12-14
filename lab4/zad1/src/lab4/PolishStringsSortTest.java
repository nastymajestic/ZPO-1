package lab4;

import org.junit.Test;

import java.text.Collator;
import java.util.Locale;

import static org.junit.Assert.assertArrayEquals;

public class PolishStringsSortTest<test> {
    public static Collator c = Collator.getInstance(Locale.getDefault());

    @Test
     public void testy() {

        String[] names = {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
                "Zyta", "Órszula", "Świętopełk" };
        String test1[] = PolishStringsSort.fastSortStrings(c, names);
        String test2[] = PolishStringsSort.fastSortStrings2(c, names);
        String test3[] = PolishStringsSort.sortStrings(c, names);

        assertArrayEquals(test1, names);
        assertArrayEquals(test2, names);
        assertArrayEquals(test3, names);

    }
}