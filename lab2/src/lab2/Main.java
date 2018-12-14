package lab2;

public class Main {
    /**
     * funkcja rysujLinijke rysuje pionowa linijke z wykorzystaniem rekurencji;
     *
     * @param nJednostek jest to dlugosc podana w danych jednostkach
     * @param nZagniezdzen jest to liczba poziomow zagniezdzen
     *
     */
    public static void rysujLinijke(int nJednostek, int nZagniezdzen) {
        rysujKreske(nZagniezdzen, 0); // rysuje jedna linie z onaczeniem
        for (int i = 1; i <= nJednostek; i++){
            rysujKreski(nZagniezdzen- 1); // draw ticks for this inch
            rysujKreske(nZagniezdzen, i); // kolejna ---- z numerem
        }
    }

    /**
     * funkcja rysuje linijke o podanej podzialce w srodku oraz mniejsze lunijki po drugiej stronie
     * rekurencyjnie najpierw rysowana jest gorna czesc, dlugosc podzialki, a potem dolna linijka
     * @param iloscKresek dlugosc podzialki
     */
    public static void rysujKreski(int iloscKresek) {
        if (iloscKresek > 0) { // przerywa sie gdy = 0
            rysujKreski(iloscKresek- 1);
            rysujKreskebezEtykiety(iloscKresek);
            rysujKreski(iloscKresek- 1); // rekurencyjnie rysuje gorna polowe podzialki
        }
    }

    /**
     * Funkcja rysuje linie o zadanej ilosci kresek, bez podanej etykiety (oznaczenia 0,1,2,3)
     * @param iloscKresek ilosc "-" zawartych w danej linii
     */
    public static void rysujKreskebezEtykiety(int iloscKresek) {
        rysujKreske(iloscKresek, - 1);
    }

    /**
     * Funkcja rysuje linie o podanej ilosci kresek wraz z etykieta/oznaczeniem liczbowym (0,1,2,3)
     * @param iloscKresek ilosc rysowanych kresek w danej linii
     * @param liczbaZagniezdzen etykieta (liczba wyswietlona jako oznaczenie)
     */

    public static void rysujKreske(int iloscKresek, int liczbaZagniezdzen) {
        for (int i = 0; i < iloscKresek; i++)
            System.out.print("-");

        if (liczbaZagniezdzen >= 0) System.out.print(" " + liczbaZagniezdzen);
        System.out.print("\n");
    }

    public static void main(String[] args) {
        rysujLinijke(2,4);

    }
}
