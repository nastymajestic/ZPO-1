import java.util.Random;

public class Osoba implements Runnable {
    private static Random rnd = new Random();
    private static double PRAWOPODOBIENSTWO = 0.05;
    private double wylosowanePrawdopodobienstwo = rnd.nextDouble();


    @Override
    public void run() {
//        System.out.println("ruszyl run osoby");

        try {
            Thread.sleep(czasPodejmowaniaDecyzji());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (wylosowanePrawdopodobienstwo < PRAWOPODOBIENSTWO) {
            chetniDoKina();
        }
        Thread.yield();

    }

    public static int czasPodejmowaniaDecyzji() {
        int liczbaSekund = rnd.nextInt(5) + 1;
        int milisekundy = liczbaSekund * 1000;
        return milisekundy;
    }

    public static synchronized void chetniDoKina() {
        Main.chetnychDoKina += 1;
    }

}
