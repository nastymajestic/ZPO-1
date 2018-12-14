package lab01;

public class PeselValidator {
           private String data;
           private  String  plec;


    public PeselValidator(String pesel) throws NumberException {
        this.sprawdzeniePeselu(pesel);
        this.data = this.getBirth(pesel);
        this.plec = this.getSex(pesel);
    }

    public Boolean sprawdzeniePeselu(String pesel) throws NumberException {
        Boolean helper = true;
        char tab[] = pesel.toCharArray();
        Integer pesel_int[] = new Integer[pesel.length()];
        for(int i = 0;i<pesel.length();i++){
            pesel_int[i] =  Integer.parseInt(String.valueOf(tab[i]));
        }
        Integer czy_poprawne =(9*pesel_int[0]+7*pesel_int[1]+3*pesel_int[2]+1*pesel_int[3]+9*pesel_int[4]+7*pesel_int[5]+3*pesel_int[6]+1*pesel_int[7]+9*pesel_int[8]+7*pesel_int[9])/10;
        if(czy_poprawne==pesel_int[10]){
            System.out.println("niepoprawnie wpisany pesel suma kontrolna sie nie zgadza");
            System.exit(0);

        }

        return helper;
    }




    public String getBirth(String pesel){
        String data = "";
        char tab[] = pesel.toCharArray();
        Integer pesel_int[] = new Integer[pesel.length()];
        for(int i = 0;i<pesel.length();i++){
            pesel_int[i] =  Integer.parseInt(String.valueOf(tab[i]));
        }

        Integer dzien,miesiac,rok;
        rok = 10 * pesel_int[0];
        rok += pesel_int[1];
        miesiac = 10 * pesel_int[2];
        miesiac += pesel_int[3];
        dzien = 10 * pesel_int[4];
        dzien += pesel_int[5];

        if (miesiac > 80 && miesiac < 93) {
            miesiac -= 80;
            rok += 1800;
        }
        else if (miesiac > 20 && miesiac < 33) {
            miesiac -= 20;
            rok += 1900;
        }
        else if (miesiac > 40 && miesiac < 53) {
            miesiac -= 40;
            rok += 2000;
        }
        else if (miesiac > 60 && miesiac < 73) {
            miesiac -= 60;
            rok += 2100;
        }
        data = String.valueOf(dzien)+" " + String.valueOf(miesiac)+" " + String.valueOf(rok);



        return data;
    }
    public String getSex(String pesel){
        String sex;
        char tab[] =pesel.toCharArray();
        Integer temp = Integer.parseInt(String.valueOf(tab[9]));
        if(temp %2 == 1){
                sex = "mezczyzna";
        }else{
            sex = "kobieta";
        }

        return sex;
    }
    public String toString(){
        return "Twoja data urodzaenia to "+ this.data+"\nTwoja plec to:" + this.plec;
    }



}
