import java.util.ArrayList;
import java.util.concurrent.*;

public class Main {
    public static int chetnychDoKina = 0;
    public static int aktualniWidzowie = 0;
    private static int ILOSCOSOB = 100;


    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(ILOSCOSOB);

        for (int i = 0; i < ILOSCOSOB; i++) {
            executor.execute(new Osoba());
        }

        Thread.sleep(2000);
        System.out.println("Mamy tylu chętnych do kina :" + chetnychDoKina);
        aktualniWidzowie = chetnychDoKina;
        ((ExecutorService) executor).shutdown();
        Executor executor2 = Executors.newFixedThreadPool(aktualniWidzowie);
        if (chetnychDoKina < 5) {
            System.out.println("Przepraszamy, filmu nie będzie.");
        } else {

            System.out.println("rozpoczecie filmu");

            Thread.sleep(2000); // tutaj jest imitacja 2s pierwszej polowy

            for (int i = 0; i < aktualniWidzowie; i++) {
                executor2.execute(new Widz());
            }

            ((ExecutorService) executor2).shutdown();
            if (aktualniWidzowie >= 5) {
                Thread.sleep(2000);   // tutaj jest imitacja 2s drugiej polowy
                System.out.println("Koniec przepysznego filmu");
            } else {

                System.out.println("Bardzo obrazliwy komunikat o frajerach”");
            }
        }


    }
}
