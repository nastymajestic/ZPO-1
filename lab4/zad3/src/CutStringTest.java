import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

public class CutStringTest {
    @Test
    public void testy() {


        assertIterableEquals(Splitter.fixedLength(4).split("Ala ma kota"), CutString.cutStrings("Ala ma kota",4));

    }

}

