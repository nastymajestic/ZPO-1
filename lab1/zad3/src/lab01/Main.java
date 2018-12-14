package lab01;

import java.util.Scanner;

public class Main {

    public static void peselCheck(String pesel) throws NumberException {
    	if(!(pesel.matches("[0-9]{11}"))){
			throw new NumberException();
		}

    }

    public static void main(String[] args) throws NumberException {
            String pesel;
            try {
                System.out.println("Wpisz swoj pesel");
                Scanner oct = new Scanner(System.in);
                pesel = oct.nextLine();
                peselCheck(pesel);
                PeselValidator pesel_obj = new PeselValidator(pesel);

                System.out.println(pesel_obj.toString());
            }catch (NumberException e){
                System.out.println(e+"\nwpisales zle pesel");
            }

		}

}
