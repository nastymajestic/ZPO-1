public class Main {

    public static void main(String[] args) throws Exception {
        Publikacja k1 = new Ksiazka("Adam Mickiewicz", "Pan Tadeusz", 340);
        Publikacja k2 = new Ksiazka("Adam Mickiewicz", "Dziady", 130);
        Publikacja kk1 = new KsiazkaZOkladkaZwykla(k1);  Publikacja kk2 = new KsiazkaZOkladkaTwarda(k2);
        //Publikacja fakeBook = new KsiazkaZObwoluta(k1);  // wyjątek! Nie można obłożyć obwolutą książki, która nie posiada okładki
        Publikacja kkk2 = new KsiazkaZObwoluta(kk2); // a tu OK
// Publikacja odrzut = new KsiazkaZObwoluta(kkk2);  // wyjątek! Obwoluta może być jedna
        Publikacja dziadyZAutografemWieszcza =    new KsiazkaZAutografem(kk2, "Drogiej Hani - Adam Mickiewicz");
        System.out.println(dziadyZAutografemWieszcza);

       // Publikacja dziadyZDwomaAutografami = new KsiazkaZAutografem(   dziadyZAutografemWieszcza, "Haniu, to nieprawda, Dziady napisałem ja, Julek Słowacki!");   // wyjątek! Autograf może być tylko jeden

    }
}
