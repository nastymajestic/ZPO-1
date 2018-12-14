import java.time.*;
import java.time.temporal.ChronoUnit;

public class Main {

    private static final int ADDITIONALDAY = 1;
    public static void main(String[] args) {

        LocalDate firstDay = LocalDate.of( 1939,9,1);
        LocalDate lastDay = LocalDate.of(1945,5,8);
        Long dayAmount = ChronoUnit.DAYS.between(firstDay, lastDay)+ ADDITIONALDAY;
        System.out.println("The Second World War lasted " + dayAmount+ " days");
        // --------------------------------------------------------------------------------b
        LocalDate randomDate = LocalDate.ofYearDay(2016, 6);
        System.out.println("68th day of 2016 was "+randomDate.getDayOfWeek()+" in "+randomDate.getMonth());
        //-----------------------------------------------------------------------------------
        LocalDate now = LocalDate.of(2020, 3, 30);
        LocalDate birthdayDate = LocalDate.of(1997, 07, 30);
        int age = (int) ChronoUnit.YEARS.between(birthdayDate, now);
        int coutOfLeap = 0;
        for(int i = 0;i<age;i++){
            LocalDate temp = now.minusYears(i);
            if(temp.isLeapYear()==true){
                coutOfLeap++;
            }

        }
        System.out.println(coutOfLeap+" years leap ");

    }
}
