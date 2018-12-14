import com.google.common.base.Splitter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class CutStringTest {
    @Test
    public void testy() {


       assertIterableEquals(Splitter.fixedLength(4).split("Ala ma kota"), Main.cutStrings("Ala ma kota",4));

    }

}
