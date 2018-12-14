import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        double miejscezerowe;
        Bisekcja xd = new Bisekcja();
        miejscezerowe = xd.biscetion(-3,-1 );
      //  miejscezerowe = xd.biscetion(-2,2 );
        System.out.println(miejscezerowe);
    }
}
