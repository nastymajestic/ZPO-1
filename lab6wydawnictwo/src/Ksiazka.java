public abstract class Ksiazka {
    String tytul;
    String autor;
    int liczbastron;
    Ksiazka(String tyt,String aut,int liczbastr){
        this.tytul=tyt;
        this.autor=aut;
        this.liczbastron=liczbastr;
    }

    @Override
    public String toString() {
        return "Autor: "+tytul+" Tytul: "+autor+" Liczba stron:"+liczbastron;
    }
}
