import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String sentence;
        String wybor,ocena;
        Scanner odczyt = new Scanner(System.in);
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 9876);
        System.out.println("podaj index studenta");
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        sentence = inFromUser.readLine();
        System.out.println(sentence);

        outToServer.writeBytes(sentence + '\n');  // tutaj wywalaa na serwer  odp

        ObjectInputStream ios = new ObjectInputStream(clientSocket.getInputStream());
        try {
            Student student = (Student)ios.readObject();
            System.out.println("FROM SERVER: " + student);
            System.out.println("Czy chcesz dopisac ocene? 'jesli tak to 'T' wpisanie innej litery spowoduje zakonczenie programu ' ");
            wybor = odczyt.nextLine();
            System.out.println(wybor);
            if(wybor.equals("T")){
                System.out.println("Jaka ocene chcesz dodac");
                ocena = odczyt.nextLine();

                student.dodajOcene((String)ocena);
                System.out.println("dodaje ocene "+ocena);
                System.out.println(student.toString());

            ObjectOutputStream objectSendToServer = new ObjectOutputStream(clientSocket.getOutputStream());
            objectSendToServer.writeObject(student);



            }else{
                System.out.println("koniec programu");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        clientSocket.close();
    }
}
