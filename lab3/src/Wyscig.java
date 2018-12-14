import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.logging.Logger;

public class Wyscig {
    private static ArrayList<String> najpierwOdczytane = new ArrayList<>();
    private static Set<String> wylosowaneNazwiska = new HashSet<String>();
    private static final int ODCHYLENIESTD = 40;
    private static final int SREDNIA = 300;
    private static Random random = new Random();
    private static Timer timer = new Timer();
    private static ArrayList<Rowerzysta> jadacyRowerzysci = new ArrayList<>();
    public static long period = 10;
    public static Queue<Rowerzysta> czolowka = new PriorityQueue<Rowerzysta>();

    public static Integer losujCzas() {
        Double czas;
        Integer wylosowanyCzas;
        Random random = new Random();
        czas = random.nextGaussian() * ODCHYLENIESTD + SREDNIA;
        wylosowanyCzas = czas.intValue();
        if (wylosowanyCzas < 250) {
            wylosowanyCzas = 250;
        }
        if (wylosowanyCzas > 370) {
            wylosowanyCzas = 370;
        }
        return wylosowanyCzas;
    }


    public static void start() {
        try {
            Logger.getAnonymousLogger().info("Pobieranie danych z url");
            URL oracle = new URL("http://szgrabowski.kis.p.lodz.pl/zpo18/nazwiska.txt");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                najpierwOdczytane.add(inputLine);
            }
            in.close();
            while (wylosowaneNazwiska.size() < 15) {
                int randomIndex = random.nextInt(najpierwOdczytane.size());  // branie inta z danego przedzialu
                wylosowaneNazwiska.add(najpierwOdczytane.get(randomIndex));

            }
            Logger.getAnonymousLogger().info("wybieranie 15 nazwisk z pliku");
            ArrayList<String> tablicaWylosowanychNazwisk = new ArrayList<String>(wylosowaneNazwiska);

            timer.scheduleAtFixedRate(new TimerTask() {
                Integer obecnyIndex = 0;
                Double czasDoNastepnegoRowerzysty = 0.0;
                Double dt = (double) period * 25 / 1000;
                Integer iluDoKonca = 15;

                @Override
                public void run() {
                    if (obecnyIndex < 15 && czasDoNastepnegoRowerzysty <= 0) {
                        Logger.getAnonymousLogger().info("Statruje rowerzysta");
                        Rowerzysta statujacyRowerzysta = new Rowerzysta(tablicaWylosowanychNazwisk.get(obecnyIndex), losujCzas());
                        jadacyRowerzysci.add(statujacyRowerzysta);
                        obecnyIndex++;
                        czasDoNastepnegoRowerzysty += 60;

//                            System.out.println("tworze nowego typa nr"+obecnyIndex);
//                            System.out.println(statujacyRowerzysta.getName() +statujacyRowerzysta.getTime());
                    }

                    czasDoNastepnegoRowerzysty -= dt;

                    for (Rowerzysta r : jadacyRowerzysci) {
                        r.delayTime(dt);

                    }


                    jadacyRowerzysci.removeIf(rowerzysta -> {
                        if (rowerzysta.getTime() < 0) {
                            Logger.getAnonymousLogger().info("rowerzysta dojechal");
                            czolowka.add(rowerzysta);
                            //System.out.println("rowerzysta ktory ostatnio ukonczyl:\n");
                            Main.ostatni.getItems().clear();
                            Main.ostatni.getItems().add(rowerzysta);
                           // System.out.println(rowerzysta.getName() + rowerzysta.getPoczatkowy_time()); // ten ostatnio ukonczyl
                            iluDoKonca--;
                            najlepszeWyniki();

                            return true;
                        }
                        return false;

                    });


                        if(iluDoKonca==0){
                            Logger.getAnonymousLogger().info("koniec wyscigu");
                            timer.cancel();
                        }


                }
            }, 0, period);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static public void najlepszeWyniki() {
        Main.najlepszeWyniki.getItems().clear();
        //System.out.print("---------------------------------\n");
        Rowerzysta rowerzysta;
        Integer miejsce = 1;
        Queue<Rowerzysta> resultsCopy = new PriorityQueue<>(czolowka);
        while ((rowerzysta = resultsCopy.poll()) != null) {
            Main.najlepszeWyniki.getItems().add(rowerzysta);
           // System.out.println(miejsce+"."+rowerzysta.getName()+" "+rowerzysta.getPoczatkowy_time());
            miejsce++;
            if (miejsce == 4)
                break;
        }

    }


}
