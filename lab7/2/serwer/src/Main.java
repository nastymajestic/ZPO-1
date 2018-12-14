import com.sun.security.ntlm.Server;

import java.io.*;
import java.net.*;

class UDPServer {
    public static int iloscWywolan=0;
    public static void liczbaPierwsza(){
        //System.out.println("liczbapierwsza++");
        iloscWywolan++;
    }
    public static void iloscLiczbPierwszychwPrzedziale(Integer s,Integer e){
        for(int i = s; i <= e; i++){

            if(isPrime(i)){
                liczbaPierwsza();
            }

        }

    }

    private static boolean isPrime(int m) {
            if(m == 1)
                return false;

            if(m == 2 || m == 3)
                return true;

            if(m > 3)
            {
                for(int i = 2; i<=(Math.sqrt(m)+0.0001); i++)
                {
                    if(m%i == 0)
                    {
                        return false;
                    }
                }
            }
            return true;
        }

    public static void main(String args[]) throws Exception {
        double optymalizer = 0.5;
        ServerSocket serverSocket = new ServerSocket(9876);
        while(true){
            Socket connectionSocket = serverSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            Long startTime = System.nanoTime();
            String sentence = inFromClient.readLine();
            String[] przedzialArray = sentence.split(";");

            Integer s = Integer.valueOf(przedzialArray[0]);
            Integer e = Integer.valueOf(przedzialArray[1]);
            Integer startDrugiegoPrzedzialu =(int)(optymalizer*(e-s)/2);
            Integer koniecPierwszegoPrzedzialu = startDrugiegoPrzedzialu-1;

            Thread thread1 = new Thread () {

                public void run () {
                    iloscLiczbPierwszychwPrzedziale(s,koniecPierwszegoPrzedzialu);


                }
            };
            Thread thread2 = new Thread () {
                public void run () {
                    iloscLiczbPierwszychwPrzedziale(startDrugiegoPrzedzialu,e);
                }
            };

           thread1.start();
           thread2.start();
            //iloscWywolan =0;
            //iloscLiczbPierwszychwPrzedziale(s, e);
//
//           thread1.join();
//           thread2.join();
            Long endTime = System.nanoTime();

            Double totalTime =(endTime-startTime)/10000000000.0;

            System.out.println("RECEIVED: " + sentence + "time"+totalTime);
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            outToClient.writeBytes("count of prime numbers: "+iloscWywolan + " time  "+totalTime+"\n");
            iloscWywolan = 0;
            outToClient.flush();

        }
    }
}