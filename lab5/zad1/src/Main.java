import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> listPL = new ArrayList<>();
        try (Stream<String> stream = new BufferedReader(new FileReader("C:\\Users\\Wika\\Desktop\\SEM5\\ZPO\\lab5\\zad1\\src\\Dane.txt")).lines()) {
            stream.filter(s -> s.contains("PL")).forEach(listPL::add);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

       // System.out.println(listPL);
        Pattern pattern = Pattern.compile("\\d+");

        List<Integer> listPensja = new ArrayList<>();
        for(int i = 0;i<listPL.size();i++){
            String element  = listPL.get(i);
            Matcher matcher = pattern.matcher(element);
            matcher.find();
            int pensja = Integer.parseInt(matcher.group());
            // System.out.println(pensja);
            listPensja.add(pensja);

        }
        System.out.println("PL - "+listPensja.size());

        System.out.println("suma pensji 2 najmniej zarabiajacych: " + listPensja.stream()
                .sorted()
                .limit(2)
                .mapToInt(Integer::intValue)
                .sum());

        System.out.println("suma pensji 2 najlepiej zarabiajacych: " + listPensja.stream()
                .sorted(Comparator.reverseOrder())
                .limit(2).mapToInt(Integer::intValue).sum());
        System.out.println();



    }
}
