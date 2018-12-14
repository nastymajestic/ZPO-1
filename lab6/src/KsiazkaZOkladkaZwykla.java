public class KsiazkaZOkladkaZwykla extends DekoratorPublikacja {
    public KsiazkaZOkladkaZwykla(Publikacja p) throws  Exception {
        super(p);
        if (p instanceof KsiazkaZOkladkaZwykla || p instanceof KsiazkaZOkladkaTwarda) {
            throw new Exception("Książka może zawierać tylko jedną okładkę");
        }
    }
    @Override
    public String toString() {
        return dekoratorPublikacja.toString() + " okadka zwykla |";
    }
}
