import java.sql.*;
import java.util.Scanner;

public class TestOracleConnection {
    public static ResultSet resultSet = null;
    public static Scanner reader = new Scanner(System.in);
    public static char wybor;
    public static boolean czyDalej = true;

    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pracownicy", "root", "1234");
            System.out.println("connection successfully");

            Statement stmt = con.createStatement();

            stmt.executeUpdate("CREATE TABLE `pracownicy` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `imie` VARCHAR(45) NOT NULL,\n" +
                    "  `nazwisko` VARCHAR(45) NOT NULL,\n" +
                    "  `kraj` VARCHAR(2) NOT NULL,\n" +
                    "  `placa` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`));");
            stmt.executeUpdate("insert into pracownicy (imie,nazwisko,kraj,placa) values('Jan','Kowalski', 'PL',35000);");
            stmt.executeUpdate("insert into pracownicy (imie,nazwisko,kraj,placa) values('Helmut','Schnittke','DE',45000);");
            stmt.executeUpdate("insert into pracownicy (imie,nazwisko,kraj,placa) values('Jiri','Prohazka','CZ',28000);");
            stmt.executeUpdate("insert into pracownicy (imie,nazwisko,kraj,placa) values('Anna','Malinowska','PL',52000);");
            stmt.executeUpdate("insert into pracownicy (imie,nazwisko,kraj,placa) values('Józef','Bšk', 'PL', 49999);");
            stmt.executeUpdate("insert into pracownicy (imie,nazwisko,kraj,placa) values('Kleofas', 'Ogiński', 'PL', 45000);");
            stmt.executeUpdate("insert into pracownicy (imie,nazwisko,kraj,placa) values('John', 'Bull', 'US', 74000);");
            stmt.executeUpdate("insert into pracownicy (imie,nazwisko,kraj,placa) values('Łukasz', 'Żółw', 'PL', 9400);");
            stmt.executeUpdate("insert into pracownicy (imie,nazwisko,kraj,placa) values('Franz', 'Beckenbauer', 'DE', 83000);");
            stmt.executeUpdate("insert into pracownicy (imie,nazwisko,kraj,placa) values('Frantisek', 'Kupka', 'CZ', 32000);");
            stmt.executeUpdate("insert into pracownicy (imie,nazwisko,kraj,placa) values('Jakub', 'Kowal', 'PL', 29500);");
            stmt.executeUpdate("insert into pracownicy (imie,nazwisko,kraj,placa) values('Jim', 'Hart', 'US', 57900);");
            stmt.executeUpdate("insert into pracownicy (imie,nazwisko,kraj,placa) values('Tomas', 'Svoboda', 'CZ', 48500);");

            //menuuuuuu


            while (czyDalej) {
                System.out.println("Wpisz litere \n 'a' - sortowanie tabeli wedlug wybranego pola \n 'b' - wyswietlenie sredniej plac dla krajow \n 'c' - dodanie nowego pracownika \n 'd' - wyswietlenie listy pracownikow\n 'e' - wyjscie z programu");
                wybor = reader.next().charAt(0);
                if (wybor == 'a') {
                    System.out.println("podaj nazwe tabeli wedlug ktorej chcesz posortowac pracownikow");
                    String nazwaTabeli = reader.next();
                    resultSet = getPracownicyPosortowani(stmt, nazwaTabeli);
                    wypiszDane(resultSet);
                    czyChceszEdytowacDalej();
                }
                if (wybor == 'b') {
                    resultSet = getSredniaPlace(stmt);
                    wypiszSredniaPlace(resultSet);
                    czyChceszEdytowacDalej();
                }
                if (wybor == 'd') {
                    resultSet = getPracownicy(stmt);
                    wypiszDane(resultSet);
                    czyChceszEdytowacDalej();
                }
                if (wybor == 'c') {
                    String imie, nazwisko, kraj;
                    int placa;
                    System.out.println("podaj imie");
                    imie = reader.next();
                    System.out.println("podaj nazwisko");
                    nazwisko = reader.next();
                    System.out.println("podaj kraj");
                    kraj = reader.next();
                    System.out.println("podaj place");
                    placa = reader.nextInt();
                    Pracownicy p = new Pracownicy(imie, nazwisko, kraj, placa);
                    addPerson(con, p);
                    czyChceszEdytowacDalej();
                }
                if (wybor == 'e') {
                    czyDalej = false;
                }

            }
            stmt.executeUpdate("drop table pracownicy");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
        }
    }

    public static void wypiszDane(ResultSet resultSet) throws SQLException {

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String imie = resultSet.getString("imie");
            String nazwisko = resultSet.getString("nazwisko");
            String kraj = resultSet.getString("kraj");
            Integer placa = resultSet.getInt("placa");
            System.out.println(id + " " + imie + " " + nazwisko + " " + kraj + " " + placa);

        }

    }

    public static ResultSet getPracownicyPosortowani(Statement statement, String nazwaTabeli) throws SQLException {
        String sqlQuery = "select * from pracownicy order by " + nazwaTabeli + " asc";
        ResultSet rs = statement.executeQuery(sqlQuery);
        return rs;
    }

    public static ResultSet getPracownicy(Statement statement) throws SQLException {
        String sqlQuery = "select * from pracownicy";
        ResultSet rs = statement.executeQuery(sqlQuery);
        return rs;
    }

    public static ResultSet getSredniaPlace(Statement statement) throws SQLException {
        String sqlQuery = "select avg(placa),kraj from pracownicy group by kraj";
        ResultSet rs = statement.executeQuery(sqlQuery);
        return rs;
    }

    public static void wypiszSredniaPlace(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String srednia = resultSet.getString("avg(placa)");
            String kraj = resultSet.getString("kraj");
            System.out.println("kraj: " + kraj + " średnia:" + srednia);
        }
    }

    public static void czyChceszEdytowacDalej() {
        System.out.println("Jeśli chcesz kontunować wybierz t 't' w przeciwnym wypadku nastapi koniec programu");
        char dodatkowyWybor = reader.next().charAt(0);
        if (dodatkowyWybor != 't') {
            czyDalej = false;
        }

    }


    public static int addPerson(Connection con, Pracownicy p) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO pracownicy (imie,nazwisko,kraj,placa) VALUES (?,?,?,?)");
            ps.setString(1, p.getImie());
            ps.setString(2, p.getNazwisko());
            ps.setString(3, p.getKraj());
            ps.setInt(4, p.getPlaca());

            return ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
        }
    }
}

