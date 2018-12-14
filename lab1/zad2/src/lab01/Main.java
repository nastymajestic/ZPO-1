package lab01;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Integer liczba = 0b1101_1000;
        Scanner odczyt  = new Scanner(System.in);
        System.out.println("Podaj slownie system liczbowy na ktory chcesz konwertowac liczbe");
        String wybor = odczyt.nextLine();
        //System.out.println(wybor);
        switch (wybor){
            case "trzy":
                System.out.println(Integer.toString(liczba,3));
                break;
            case "dziesięć":
                System.out.println(Integer.toString(liczba,10));
                break;
            case "szesnaście":
                System.out.println(Integer.toString(liczba,16));

                break;
            default:
                System.out.println("podales zla podstawe");
        }
    }
    }



