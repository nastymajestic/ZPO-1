
public class Pracownicy {

    String imie;
    String nazwisko;
    String kraj;
    int placa;


    public Pracownicy(String imie, String nazwisko, String kraj, int placa) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.kraj = kraj;
        this.placa = placa;
    }


    public String getImie() {
        return imie;
    }


    public String getNazwisko() {
        return nazwisko;
    }

    public String getKraj() {
        return kraj;
    }


    public int getPlaca() {
        return placa;
    }

}
