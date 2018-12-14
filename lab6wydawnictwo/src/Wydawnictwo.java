public abstract class Wydawnictwo {
    String autor;

    public static Wydawnictwo getInstance(String autor){
        if(autor.equals("Józef Ignacy Kraszewski")){
            return new WydawnictwoPowiesciHistorycznych(autor);
        }
        if(autor.equals("Autor od trillerow")){
            return new WydawnictwoThrillerow(autor);
        }
        if(autor.equals("autor od poematow")){
            return new WydawnictwoPoematow(autor);
        }
        return null;
}

    public abstract Ksiazka createBook(String maslaw,int pageAmount);
}
