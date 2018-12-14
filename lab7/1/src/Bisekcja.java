import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bisekcja {
    public double function(double x){
       // return ((-x)*x+2*x);
       return (x+2);
    }

    public  static double e = 0.001;

    public double biscetion(double a, double b){
        List<Double> x = new ArrayList<>();
        x.add(a);
        x.add(b);

        double x1 = (a+b)/2;
        x.add(x1);
//        if(function(x1)==0) {
//            System.out.println("miejscem zerowym przedzialu a,b jest" + x1);
//        }

//        }else{
//            while(Math.abs(a-b)>e){
//                x1 = (a+b)/2;
//                System.out.println(x1);
//                if(function(x1)<=e)
//                    break;
//                else if(function(x1)*function(a)<0){
//                    b=x1;
//                }else if(function(x1)*function(b)<0){
//                    a=x1;
//                }
//                if(function(x1)==0) {
//                    return x1;
//                }
//            }
//        }

            List<Double> y = Lists.transform(x, this::function);// tu oblcizanie szybkie dla y
            assert (y.get(0) * y.get(1) < 0) : "podales zly zakres";

            int i = Collections.binarySearch(y, 0.0);
//        System.out.println(i);
//        System.out.println(y);


            System.out.println();
            return i;
        }

    }
