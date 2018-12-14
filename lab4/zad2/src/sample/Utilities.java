package sample;

public class Utilities {
    private static String name;
    private static String surname;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Utilities.name = name;
    }

    public static String getSurname() {
        return surname;
    }

    public static void setSurname(String surname) {
        Utilities.surname = surname;
    }

    @Override
    public String toString() {
        return this.name+this.surname;
    }
}
