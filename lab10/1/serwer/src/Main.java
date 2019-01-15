import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Student> studenci = new ArrayList<>();
    public static Student Wika = new Student("Wika", "SOczyk", "209222");
    public static Student Afrika = new Student("Afrika", "SOczyk", "2092212");
    public static Student Michal = new Student("Michal", "dasd", "123445");

    public static void main(String args[]) throws Exception {
        studenci.add(Wika);
        studenci.add(Afrika);
        studenci.add(Michal);
        Wika.dodajOcene("3");
        ServerSocket serverSocket = new ServerSocket(9876);
        while (true) {
            Socket connectionSocket = serverSocket.accept();
            try {
                // otrzymano  indeks studneta
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                String sentence = inFromClient.readLine();
                System.out.println("RECEIVED: " + sentence);
                //-----------------------------

                // tu wysylam studenta o podanym indeksie
                ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
                outToClient.writeObject(getStudentbyIndex(sentence));
                //-----------------------------------

                // odbieram zmodyfikowanego studenta
                ObjectInputStream objectFromClient = new ObjectInputStream(connectionSocket.getInputStream());
                Student odebranyStudent = (Student) objectFromClient.readObject();
                System.out.println(odebranyStudent);
                //
                //modyfikowanie tablicy

                modifyListStudents(odebranyStudent);
                outToClient.close();

                System.out.println(studenci);
            }catch (Exception e){
                e.printStackTrace();
            }


        }

    }

    public static Student getStudentbyIndex(String index) {
        for (int i = 0; i < studenci.size(); i++) {
            if (studenci.get(i).getStudentIndex().equals(index)) {
                System.out.println("znalazlem studneta o takim id");
                return studenci.get(i);
            }
            System.out.println("jestem w petli studenci");
        }

        System.out.println("brak studenta w bazie o takim id");
        return null;
    }

    public static void modifyListStudents(Student s) {
        for (int i = 0; i < studenci.size(); i++) {
            if (studenci.get(i).getStudentIndex().equals(s.getStudentIndex())) {
                studenci.set(i, s);
            }
        }


    }

}
