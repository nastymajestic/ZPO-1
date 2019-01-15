import java.util.Random;

public class Widz implements Runnable {
    private static Random rnd = new Random();
    private static double PRAWDOPODOBIENSTWO = 0.3;
    private double wylosowanePrawdopodobienstwo = rnd.nextDouble();


    @Override
    public void run() {

        if (wylosowanePrawdopodobienstwo < PRAWDOPODOBIENSTWO) {
            halinaWychodzimy();
        }
        Thread.yield();
    }


    public static synchronized void halinaWychodzimy() {
        Main.aktualniWidzowie -= 1;
        System.out.println("halina wychodzimy");
    }
}
