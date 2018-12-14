public class WydawnictwoPowiesciHistorycznych extends Wydawnictwo {
    public WydawnictwoPowiesciHistorycznych(String autor) {
        super.autor = autor;
    }

    public Ksiazka createBook(String tytul, int liczbastron) {
        return new PowiescHistoryczna(autor, tytul, liczbastron);
    }
}
