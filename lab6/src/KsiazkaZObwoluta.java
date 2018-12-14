public class KsiazkaZObwoluta extends DekoratorPublikacja {
    public KsiazkaZObwoluta(Publikacja p) throws Exception {
        super(p);
        if(p instanceof KsiazkaZObwoluta){
            throw new Exception("Obwaluta może być tylko jedna");
        }
        if(!(p instanceof KsiazkaZOkladkaTwarda || p instanceof KsiazkaZOkladkaZwykla )){
            throw new Exception("Aby założyć obwalute, książka musi mieć okładkę!");
        }
    }
    @Override
    public String toString() {
        return dekoratorPublikacja.toString() + " ksiazka z obwaluta |";
    }

}
