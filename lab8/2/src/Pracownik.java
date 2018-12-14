import java.util.Objects;

public class Pracownik {
    private String imie;
    private int id;
    private double pensja;
    private  boolean plec;

    Pracownik(String im,int idd, double cash, boolean sex){
        this.imie = im;
        this.id = idd;
        this.pensja = cash;
        this.plec = sex;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    public boolean isPlec() {
        return plec;
    }

    public void setPlec(boolean plec) {
        this.plec = plec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pracownik pracownik = (Pracownik) o;
        return id == pracownik.id &&
                plec == pracownik.plec &&
                Objects.equals(imie, pracownik.imie);
    }

}
