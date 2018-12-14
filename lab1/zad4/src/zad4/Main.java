package zad4;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws NumberException {
        String input;
        String output = "";
        try {
            input = JOptionPane.showInputDialog("wpisz liczbe");
            checkNumber(input);
            char tab[]=input.toCharArray();

            HashMap numberMap = new HashMap<Integer, String>();
            numberMap.put(0,"zero");
            numberMap.put(1,"jeden");
            numberMap.put(2,"dwa");
            numberMap.put(3,"trzy");
            numberMap.put(4,"cztery");
            numberMap.put(5,"pięć");
            numberMap.put(6,"sześć");
            numberMap.put(7,"siedem");
            numberMap.put(8,"osiem");
            numberMap.put(9,"dziewięć");

            if(tab[0]=='-'){
                output ="minus ";
                for (int j = 1; j < tab.length; j++) {

                    Integer temp = Integer.parseInt(String.valueOf(tab[j]));
                    System.out.println(temp);
                    if (numberMap.containsKey(temp)) {
                        output = output + numberMap.get(temp) + " ";
                    }

                }

                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), output);
            }else{
                for (int j = 0; j < tab.length; j++) {

                    Integer temp = Integer.parseInt(String.valueOf(tab[j]));
                    System.out.println(temp);
                    if (numberMap.containsKey(temp)) {
                        output = output + numberMap.get(temp) + " ";
                    }

                }

                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), output);
            }
        }catch (NumberException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "wpisales zly format liczby");
        }

    }

    public static void checkNumber(String number) throws NumberException {

                    if(!number.matches("-{0,1}+[0-9]{3}"))
                    throw new NumberException();

    }
}
