public class Main {

    public static void main(String[] args) {
        Wydawnictwo w = Wydawnictwo.getInstance("Józef Ignacy Kraszewski");
        Ksiazka k = w.createBook("Masław", 280);
        Wydawnictwo w2 = Wydawnictwo.getInstance("Autor od trillerow");
        Ksiazka k2 = w2.createBook("Swietny Thriller", 666);
        Wydawnictwo w3 = Wydawnictwo.getInstance("autor od poematow");//
        Ksiazka k3 = w3.createBook("Natchniony poemat", 123);

        System.out.println(k);
        System.out.println(k2);
        System.out.println(k3);




    }
}
