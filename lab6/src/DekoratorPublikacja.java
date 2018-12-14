public abstract class DekoratorPublikacja implements Publikacja {
    protected  Publikacja dekoratorPublikacja;
    public DekoratorPublikacja(Publikacja p){
        dekoratorPublikacja = p;
    }
    @Override
    public String getAutor() {

        return dekoratorPublikacja.getAutor();
    }

    @Override
    public String getTytul() {
        return dekoratorPublikacja.getTytul();
    }

    @Override
    public int getLiczbaStron() {
        return dekoratorPublikacja.getLiczbaStron();
    }
    @Override
    public String toString(){
        return dekoratorPublikacja.toString();
    }
}
