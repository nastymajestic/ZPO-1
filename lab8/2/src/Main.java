import java.lang.reflect.InvocationTargetException;

public class Main {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Pracownik mariola =new Pracownik("Mariola", 1, 666.00, true);
        Pracownik mariola2 = new Pracownik("Mariola",1 , 669.00,true );
        Pracownik zdzislaw = new Pracownik("zdzislaw",2 , 669.00,true );

        PracownikAdnotacja pracownikPierwszy = new PracownikAdnotacja("XD",1 , 123, true);
        PracownikAdnotacja pracowniknik2 = new PracownikAdnotacja("XD",1 , 123, true);
        System.out.println(pracownikPierwszy.equals(pracowniknik2));

        System.out.println("Porownanie za pomoca zwyklego equals");
        System.out.println(mariola.equals(mariola2));
        System.out.println(mariola.equals(zdzislaw));


    }

}
