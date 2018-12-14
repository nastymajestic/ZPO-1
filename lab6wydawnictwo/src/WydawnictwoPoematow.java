public class WydawnictwoPoematow extends Wydawnictwo {
    public WydawnictwoPoematow(String autor) {
        super.autor = autor;
    }

    public Ksiazka createBook(String tytul, int pages) {
        return new PowiescHistoryczna(autor, tytul, pages);
    }
}
