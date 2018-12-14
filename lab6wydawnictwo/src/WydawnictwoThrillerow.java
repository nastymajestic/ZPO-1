public class WydawnictwoThrillerow extends Wydawnictwo {
    public WydawnictwoThrillerow(String autor) {
        super.autor = autor;
    }

    public Ksiazka createBook(String tytul, int pages) {
        return new Thriller(autor, tytul, pages);
    }
}
