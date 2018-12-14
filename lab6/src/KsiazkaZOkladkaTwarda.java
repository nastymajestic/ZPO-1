public class KsiazkaZOkladkaTwarda extends  DekoratorPublikacja {
    public KsiazkaZOkladkaTwarda(Publikacja p) throws Exception {
        super(p);

        if(p instanceof KsiazkaZOkladkaZwykla || p instanceof KsiazkaZOkladkaTwarda){
            throw new Exception("Książka może zawierać tylko jedną okładkę");
        }
    }
    @Override
    public String toString() {
        return dekoratorPublikacja.toString() + " okadka twarda |";
    }

}
