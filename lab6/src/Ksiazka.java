public class Ksiazka implements Publikacja{

    String autor;
    String tytul;
    int liczbaStron;

    public Ksiazka(String aut,String tyt,int liczbastr){
        this.autor = aut;
        this.tytul = tyt;
        this.liczbaStron = liczbastr;
    }
    @Override
    public String getAutor() {
        return this.autor;
    }

    @Override
    public String getTytul() {
        return this.tytul;
    }

    @Override
    public int getLiczbaStron() {
        return this.liczbaStron;
    }

    @Override
    public String toString() {
        return "| "+autor+" | "+tytul+" | "+liczbaStron+" |";
    }
}
