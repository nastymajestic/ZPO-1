import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int tab[] =  {4, 10, 3, 7, 4, 1, 6, 2};
        final MaxSearchAlgorithms obiekt = MaxSearchAlgorithms.class.getConstructor().newInstance();

        Class klasa = obiekt.getClass();
        Method []methods = klasa.getDeclaredMethods();
        for (Method method : methods) {
            if(method.getName().contains("Scan"))
                {
                System.out.println(method.getName() + " " + method.invoke(obiekt, tab));
            }
        }
//        ArrayList<Integer> LeftToRight = new ArrayList<>();
//        ArrayList<Integer> RightToLeft = new ArrayList<>();
//        ArrayList<Integer> OddEvenIndex = new ArrayList<>();

//	    RightToLeft=MaxSearchAlgorithms.maxIntRightToLeftScan(tab);
//	    LeftToRight= MaxSearchAlgorithms.maxIntLeftToRightScan(tab);
//	    OddEvenIndex =MaxSearchAlgorithms.maxIntEvenOddIndexScan(tab);
//
//        System.out.println(LeftToRight);
//        System.out.println(RightToLeft);
//        System.out.println(OddEvenIndex);

    }
}
