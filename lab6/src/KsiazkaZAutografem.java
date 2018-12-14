public class KsiazkaZAutografem extends DekoratorPublikacja {
    String autograf;
    public KsiazkaZAutografem(Publikacja p,String autograf) throws Exception {
        super(p);
        this.autograf = autograf;

        if(p instanceof KsiazkaZAutografem){
            throw new Exception("ksiazka moze miec tylko jeden autograf");
        }
    }

    @Override
    public String toString() {
        return dekoratorPublikacja.toString() + autograf+"|";
    }

}
