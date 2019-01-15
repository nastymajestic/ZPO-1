import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Student implements Serializable {
    private String imie;
    private String nazwisko;
    private String indeks;
    private ArrayList<String> oceny;


    public Student(String imie,String nazwisko, String indeks){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.indeks = indeks;
        this.oceny = new ArrayList<>();
        this.oceny.add("poczatek ocen");
    }
    public void dodajOcene(String ocena){
        this.oceny.add(ocena);
    }
    public String getStudentIndex(){
        return indeks;
    }

    @Override
    public String toString() {
        return "Student{" + "imie='" + imie + '\'' + ", nazwisko='" + nazwisko + '\'' + ", indeks='" + indeks + '\'' + ", oceny="+ oceny  + '}';
    }
}
